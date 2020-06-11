package Datalayer.DAO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.RequestScoped;

import DB.DBUtil;
import Datalayer.DTO.CommodityBatchDTO;
import Datalayer.DTO.commodityDTO;
import Datalayer.Interfaces.ICommodityDAO;

@RequestScoped
public class CommodityDAO implements ICommodityDAO {

	@Override
	public commodityDTO getCommodity(int commodity_id) {

		String query = "SELECT * FROM Commodity WHERE commodityId = ?";

		ResultSet resultSet = DBUtil.executeSelectQuery( query, DBUtil.convertTOObject( commodity_id ));

		commodityDTO commoDTO = null;

		try {
			resultSet.first();
			commoDTO = (commodityDTO) DBUtil.resultSetToObject( resultSet, commodityDTO.class);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return commoDTO;
	}

	@Override
	public List<commodityDTO> getCommodityList() {
		String query = "SELECT * FROM Commodity";

		ResultSet resultSet = DBUtil.executeSelectQuery( query, null );
		List<commodityDTO> listOfCommodityDTO = null;
		try {
			commodityDTO comdDTO;
			listOfCommodityDTO = new ArrayList<>();
			while (resultSet.next()) {
				comdDTO = (commodityDTO) DBUtil.resultSetToObject(resultSet, commodityDTO.class);
				listOfCommodityDTO.add(comdDTO);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return listOfCommodityDTO;
	}

	@Override
	public void createCommodity(commodityDTO commodity) {
		String query = "INSERT INTO CommodityBatch (commodityId, commodityName) VALUES (?, ?)";
		Object[] parameter = DBUtil.convertTOObject( commodity );

		try {
			DBUtil.executeCreateAndUpdate( query, parameter );
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void updateCommodity(commodityDTO commodity) {
		String query = "UPDATE CommodityBatch SET commodityId=?, commodityBatchId=? WHERE commodityId=?";
		Object[] parameter = DBUtil.convertTOObject( commodity );

		try {
			DBUtil.executeCreateAndUpdate( query, parameter );
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

}