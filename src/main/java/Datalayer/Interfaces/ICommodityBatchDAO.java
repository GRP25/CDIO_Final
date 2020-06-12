package Datalayer.Interfaces;


import java.sql.SQLException;
import java.util.List;

import Datalayer.DTO.CommodityBatchDTO;

public interface ICommodityBatchDAO {

	CommodityBatchDTO getCommodityBatch(int commodityBatch_id) throws SQLException;

	List<CommodityBatchDTO> getCommodityBatchList() throws SQLException;

	List<CommodityBatchDTO> getCommodityBatchList(int commodityBatch_id) throws SQLException;

	void createCommodityBatch(CommodityBatchDTO batch) throws SQLException;

	void updateCommodityBatch(CommodityBatchDTO batch) throws SQLException;

}