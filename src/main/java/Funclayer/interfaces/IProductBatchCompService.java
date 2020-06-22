package Funclayer.interfaces;

import Datalayer.DTO.ProductBatchCompDTO;

import java.sql.SQLException;
import java.util.List;

public interface IProductBatchCompService {
    ProductBatchCompDTO getProductBatchComp(int productBatch_id, int commodityBatch_id) throws SQLException;

    List<ProductBatchCompDTO> getProductBatchCompList() throws SQLException;

    List<ProductBatchCompDTO> getProductBatchCompList(int productBatch_id) throws SQLException;

    void createProductBatchComp(ProductBatchCompDTO productBatchComp) throws SQLException;

    void updateProductBatchComp(ProductBatchCompDTO productBatchComp) throws SQLException;
}
