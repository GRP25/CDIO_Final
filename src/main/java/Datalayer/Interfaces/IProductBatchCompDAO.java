package Datalayer.Interfaces;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Datalayer.DTO.ProductBatchCompDTO;

/**
 * IProductBatchCompDAO
 */
public interface IProductBatchCompDAO {

	ProductBatchCompDTO getProductBatchComp(int productBatch_id, int commodityBatch_id) throws SQLException;

	List<ProductBatchCompDTO> getProductBatchCompList() throws SQLException;

	List<ProductBatchCompDTO> getProductBatchCompList(int productBatch_id) throws SQLException;

	void createProductBatchComp(ProductBatchCompDTO productBatchComp) throws SQLException;

	void updateProductBatchComp(ProductBatchCompDTO productBatchComp) throws SQLException;

	boolean exists(int pro_id, int combat_id) throws SQLException;
}