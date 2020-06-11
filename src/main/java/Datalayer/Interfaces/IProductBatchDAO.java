package Datalayer.Interfaces;

import java.util.ArrayList;

import Datalayer.DTO.ProductBatchDTO;

/**
 * IProductBatchDAO
 */
public interface IProductBatchDAO {

	ProductBatchDTO getProductBatchDTO(int productBatch_id);

	ArrayList<ProductBatchDTO> getProductBatchDTOList();

	void createProductBatch(ProductBatchDTO productBatch);

	void updateProductBatch(ProductBatchDTO productBatch);
}