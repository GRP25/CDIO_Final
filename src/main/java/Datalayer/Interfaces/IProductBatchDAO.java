package Datalayer.Interfaces;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Datalayer.DTO.ProductBatchDTO;

/**
 * IProductBatchDAO
 */
public interface IProductBatchDAO {

	ProductBatchDTO getProductBatchDTO(int productBatch_id) throws SQLException;

	List<ProductBatchDTO> getProductBatchDTOList() throws SQLException;

	void createProductBatch(ProductBatchDTO productBatch) throws SQLException;

	void updateProductBatch(ProductBatchDTO productBatch) throws SQLException;
}