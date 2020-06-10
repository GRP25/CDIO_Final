package Datalayer.Interfaces;

import java.util.ArrayList;

import Datalayer.DAO.DALException;
import Datalayer.DTO.commodityBatchDTO;

public interface ICommodityBatchDAO {

	commodityBatchDTO getCommodityBatch(int commodityBatch_id) throws DALException;

	ArrayList<commodityBatchDTO> getCommodityBatchList() throws DALException;

	ArrayList<commodityBatchDTO> getCommodityBatchList(int commodityBatch_id) throws DALException;

	void createCommodityBatch(commodityBatchDTO batch) throws DALException;

	void updateCommodityBatch(commodityBatchDTO batch) throws DALException;

}