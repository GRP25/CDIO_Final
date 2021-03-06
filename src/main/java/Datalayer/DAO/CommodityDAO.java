package Datalayer.DAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.RequestScoped;

import Datalayer.DBUtil;
import Datalayer.DAO.Interfaces.IValidation;
import Datalayer.DTO.CommodityDTO;
import Datalayer.Interfaces.ICommodityDAO;

@RequestScoped
public class CommodityDAO implements ICommodityDAO, IValidation {

	@Override
	public CommodityDTO getCommodity(int commodity_id) throws SQLException {

		CommodityDTO commoDTO = new CommodityDTO();
		String query = "SELECT * FROM Commodity WHERE commodityId = ?";
		Connection connection = DBUtil.getConnection();
		Object[] parameter = { commodity_id };

		ResultSet resultSet = DBUtil.executeSelectQuery(query, parameter, connection);

		if (resultSet.next()) {
			commoDTO.interpretResultSet(resultSet);
		}

		connection.close();
		return commoDTO;
	}

	@Override
	public List<CommodityDTO> getCommodityList() throws SQLException {
		String query = "SELECT * FROM Commodity";
		Connection connection = DBUtil.getConnection();

		ResultSet resultSet = DBUtil.executeSelectQuery(query, null, connection);
		List<CommodityDTO> listOfCommodityDTO = new ArrayList<>();
		CommodityDTO commoDTO;

		while (resultSet.next()) {
			commoDTO = new CommodityDTO();
			commoDTO.interpretResultSet(resultSet);
			listOfCommodityDTO.add(commoDTO);
		}
		connection.close();
		return listOfCommodityDTO;
	}

	@Override
	public void createCommodity(CommodityDTO commodity) throws SQLException {
		String query = "INSERT INTO Commodity (commodityId, commodityName) VALUES (?, ?)";
		Connection connection = DBUtil.getConnection();

		Object[] parameter = commodity.convertToObject();
		DBUtil.executeSelectQuery(query, parameter, connection);

		connection.close();
	}

	@Override
	public void updateCommodity(CommodityDTO commodity) throws SQLException {
		String query = "UPDATE Commodity SET commodityId=?, commodityName=? WHERE commodityId="
				+ commodity.getCommodity_id();
		Connection connection = DBUtil.getConnection();

		Object[] parameter = commodity.convertToObject();
		ResultSet resultSet = DBUtil.executeSelectQuery(query, parameter, connection);
		if (resultSet.next())
			commodity.interpretResultSet(resultSet);

		connection.close();

	}

	@Override
	public boolean exists(int id) throws SQLException {
		String query = "SELECT commodityId FROM Commodity WHERE commodityId = ?";
		Object[] parameter = { id };
		Connection connection = DBUtil.getConnection();
		ResultSet rs = DBUtil.executeSelectQuery(query, parameter, connection);

		connection.close();

		return rs.next();
	}

}