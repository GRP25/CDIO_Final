package Datalayer.Interfaces;

import java.util.ArrayList;
import java.util.List;

import Datalayer.DTO.ProductBatchDTO;

/**
 * IProductBatchDAO
 */
public interface IProductBatchDAO {

	ProductBatchDTO getProductBatchDTO(int productBatch_id);

	List<ProductBatchDTO> getProductBatchDTOList();

	void createProductBatch(ProductBatchDTO productBatch);

	void updateProductBatch(ProductBatchDTO productBatch);
}