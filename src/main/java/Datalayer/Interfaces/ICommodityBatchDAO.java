package Datalayer.Interfaces;

import java.util.ArrayList;

import Datalayer.DTO.commodityBatchDTO;

public interface ICommodityBatchDAO {

	commodityBatchDTO getCommodityBatch(int commodityBatch_id);

	ArrayList<commodityBatchDTO> getCommodityBatchList();

	ArrayList<commodityBatchDTO> getCommodityBatchList(int commodityBatch_id);

	void createCommodityBatch(commodityBatchDTO batch);

	void updateCommodityBatch(commodityBatchDTO batch);

}