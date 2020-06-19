package Funclayer.interfaces;

import Datalayer.DTO.ProductBatchDTO;
import Funclayer.exceptions.exceptions.NotProductBatchExeption;

import java.sql.SQLException;
import java.util.List;

public interface IProductBatchService {
    ProductBatchDTO getProductBatchDTO(int productBatch_id) throws SQLException;

    List<ProductBatchDTO> getProductBatchDTOList() throws SQLException;

    String createProductBatch(ProductBatchDTO productBatch) throws SQLException, NotProductBatchExeption;

    String updateProductBatch(ProductBatchDTO productBatch) throws SQLException, NotProductBatchExeption;
}
