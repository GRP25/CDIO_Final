package Datalayer.Interfaces;

import java.util.ArrayList;

import Datalayer.DTO.productBatchDTO;

/**
 * IProductBatchDAO
 */
public interface IProductBatchDAO {

	productBatchDTO getProductBatchDTO(int productBatch_id);

	ArrayList<productBatchDTO> getProductBatchDTOList();

	void createProductBatch(productBatchDTO productBatch);

	void updateProductBatch(productBatchDTO productBatch);
}