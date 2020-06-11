package Datalayer.Interfaces;

import java.util.ArrayList;

import Datalayer.DTO.ProductBatchCompDTO;

/**
 * IProductBatchCompDAO
 */
public interface IProductBatchCompDAO {

	ProductBatchCompDTO getProductBatchComp(int productBatch_id, int commodityBatch_id);

	ArrayList<ProductBatchCompDTO> getProductBatchCompList();

	ArrayList<ProductBatchCompDTO> getProductBatchCompList(int productBatch_id);

	void createProductBatchComp(ProductBatchCompDTO productBatchComp);

	void updateProductBatchComp(ProductBatchCompDTO productBatchComp);

}