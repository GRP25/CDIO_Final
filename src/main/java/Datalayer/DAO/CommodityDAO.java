package Datalayer.DAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.RequestScoped;

import Datalayer.DBUtil;
import Datalayer.DAO.Interfaces.IValidation;
import Datalayer.DTO.commodityDTO;
import Datalayer.Interfaces.ICommodityDAO;

@RequestScoped
public class CommodityDAO implements ICommodityDAO, IValidation {

	@Override
	public commodityDTO getCommodity(int commodity_id) throws SQLException {

		commodityDTO commoDTO = new commodityDTO();
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
	public List<commodityDTO> getCommodityList() throws SQLException {
		String query = "SELECT * FROM Commodity";
		Connection connection = DBUtil.getConnection();

		ResultSet resultSet = DBUtil.executeSelectQuery(query, null, connection);
		List<commodityDTO> listOfCommodityDTO = new ArrayList<>();
		commodityDTO commoDTO;

		while (resultSet.next()) {
			commoDTO = new commodityDTO();
			commoDTO.interpretResultSet(resultSet);
			listOfCommodityDTO.add(commoDTO);
		}
		connection.close();
		return listOfCommodityDTO;
	}

	@Override
	public void createCommodity(commodityDTO commodity) throws SQLException {
		String query = "INSERT INTO Commodity (commodityId, commodityName) VALUES (?, ?)";
		Connection connection = DBUtil.getConnection();

		Object[] parameter = commodity.convertToObject();
		DBUtil.executeSelectQuery(query, parameter, connection);

		connection.close();
	}

	@Override
	public void updateCommodity(commodityDTO commodity) throws SQLException {
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
		boolean ret;
		String query = "SELECT commodityId FROM Commodity WHERE commodityId = ?";
		Object[] parameter = { id };
		Connection connection = DBUtil.getConnection();
		ResultSet rs = DBUtil.executeSelectQuery(query, parameter, connection);
		if (rs.next())
			ret = true;
		else
			ret = false;
		connection.close();
		return ret;
	}

}