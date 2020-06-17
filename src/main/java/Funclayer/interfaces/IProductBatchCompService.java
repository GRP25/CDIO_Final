package Funclayer.interfaces;

import Datalayer.DTO.ProductBatchCompDTO;

import java.sql.SQLException;
import java.util.List;

public interface IProductBatchCompService {
    ProductBatchCompDTO getProductBatchComp(int productBatch_id, int commodityBatch_id) throws SQLException;

    List<ProductBatchCompDTO> getProductBatchCompList() throws SQLException;

    List<ProductBatchCompDTO> getProductBatchCompList(int productBatch_id) throws SQLException;

    String createProductBatchComp(ProductBatchCompDTO productBatchComp) throws SQLException;

    String updateProductBatchComp(ProductBatchCompDTO productBatchComp) throws SQLException;
}
