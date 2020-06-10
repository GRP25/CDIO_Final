package Datalayer.Interfaces;

import java.util.ArrayList;

import Datalayer.DTO.productBatchCompDTO;

/**
 * IProductBatchCompDAO
 */
public interface IProductBatchCompDAO {

	productBatchCompDTO getProductBatchComp(int productBatch_id, int commodityBatch_id);

	ArrayList<productBatchCompDTO> getProductBatchCompList();

	ArrayList<productBatchCompDTO> getProductBatchCompList(int productBatch_id);

	void createProductBatchComp(productBatchCompDTO productBatchComp);

	void updateProductBatchComp(productBatchCompDTO productBatchComp);

}