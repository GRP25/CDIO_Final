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
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<commodityDTO> getCommodityList() {
		String query = "SELECT * FROM Commodity";

		ResultSet resultSet = DBUtil.executeSelectQuery( query, null );
		ArrayList<commodityDTO> listOfCommodityDTO = null;
		try {
			commodityDTO cmdtDTO;
			listOfCommodityDTO = new ArrayList<>();
			while (resultSet.next()) {
				cmdtDTO = (commodityDTO) DBUtil.resultSetToObject(resultSet, commodityDTO.class);
				listOfCommodityDTO.add(cmdtDTO);
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