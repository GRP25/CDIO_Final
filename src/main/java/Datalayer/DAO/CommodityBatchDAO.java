package Datalayer.DAO;

import java.sql.ResultSet;
import java.sql.SQLException;

import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.RequestScoped;

import DB.DBUtil;
import Datalayer.DTO.CommodityBatchDTO;
import Datalayer.Interfaces.ICommodityBatchDAO;

@RequestScoped
public class CommodityBatchDAO implements ICommodityBatchDAO {

	@Override
	public CommodityBatchDTO getCommodityBatch(int commodityBatch_id) throws DALException {

		String query = "SELECT * FROM CommodityBatch WHERE commodityBatchId = ?";

		ResultSet resultSet = DBUtil.executeSelectQuery(query, DBUtil.convertTOObject(commodityBatch_id));

		CommodityBatchDTO commodityBatchDTO;

		try {
			resultSet.first();
			commodityBatchDTO = (CommodityBatchDTO) DBUtil.resultSetToObject(resultSet, CommodityBatchDTO.class);
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}

		return commodityBatchDTO;
	}

	@Override
	public List<CommodityBatchDTO> getCommodityBatchList() throws DALException {
		String query = "SELECT * FROM CommodityBatch";

		ResultSet resultSet = DBUtil.executeSelectQuery(query, null);
		List<CommodityBatchDTO> listOfCommodityBatchDTO;
		try {
			CommodityBatchDTO commodityBatchDTO;
			listOfCommodityBatchDTO = new ArrayList<>();
			while (resultSet.next()) {
				commodityBatchDTO = (CommodityBatchDTO) DBUtil.resultSetToObject(resultSet, CommodityBatchDTO.class);
				listOfCommodityBatchDTO.add(commodityBatchDTO);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}

		return listOfCommodityBatchDTO;
	}

	@Override
	public List<CommodityBatchDTO> getCommodityBatchList(int commodityBatch_id) throws DALException {
		String query = "SELECT * FROM CommodityBatch";

		ResultSet resultSet = DBUtil.executeSelectQuery(query, DBUtil.convertTOObject(commodityBatch_id));
		List<CommodityBatchDTO> listOfCommodityBatchDTO = null; // Instead of implementing same as getCommodityBatchList
																// out parameter
		try {
			CommodityBatchDTO commodityBatchDTO;
			listOfCommodityBatchDTO = new ArrayList<>();
			while (resultSet.next()) {
				commodityBatchDTO = (CommodityBatchDTO) DBUtil.resultSetToObject(resultSet, CommodityBatchDTO.class);
				listOfCommodityBatchDTO.add(commodityBatchDTO);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return listOfCommodityBatchDTO;
	}

	@Override
	public void createCommodityBatch(CommodityBatchDTO batch) throws DALException {
		String query = "INSERT INTO CommodityBatch (commodityBatchId, commodityId, weight, supplier) VALUES (?, ?, ?, ?)";
		Object[] parameter = DBUtil.convertTOObject(batch);

		try {
			DBUtil.executeCreateAndUpdate(query, parameter);
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	@Override
	public void updateCommodityBatch(CommodityBatchDTO batch) throws DALException {
		String query = "UPDATE CommodityBatch SET commodityBatchId=?, commodityId=?, weight=?, supplier=? WHERE commodityBatchId=?";

		try {
			DBUtil.executeCreateAndUpdate(query, DBUtil.convertTOObject(batch, batch.getCommodity_id()));
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}
}