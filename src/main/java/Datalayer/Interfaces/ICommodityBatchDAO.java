package Datalayer.Interfaces;


import java.util.List;

import Datalayer.DTO.CommodityBatchDTO;

public interface ICommodityBatchDAO {

	CommodityBatchDTO getCommodityBatch(int commodityBatch_id) ;

	List<CommodityBatchDTO> getCommodityBatchList() ;

	List<CommodityBatchDTO> getCommodityBatchList(int commodityBatch_id) ;

	void createCommodityBatch(CommodityBatchDTO batch) ;

	void updateCommodityBatch(CommodityBatchDTO batch) ;

}