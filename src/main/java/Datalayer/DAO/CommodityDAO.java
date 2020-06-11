package Datalayer.DAO;

import java.sql.SQLException;
import java.util.ArrayList;

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
		// TODO Auto-generated method stub
		return null;
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
	public void createCommodityBatch(CommodityBatchDTO batch) throws DALException {
		String query = "INSERT INTO CommodityBatch (commodityBatchId, commodityId, weight, supplier) VALUES (?, ?, ?, ?)";
		Object[] parameter = DBUtil.convertTOObject( batch );

		try {
			DBUtil.executeCreateAndUpdate( query, parameter );
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}


	@Override
	public void updateCommodity(commodityDTO commodity) {
		// TODO Auto-generated method stub

	}

}