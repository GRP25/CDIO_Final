package Funclayer;

import Datalayer.DTO.ProductBatchDTO;

import java.util.List;

public interface IProductBatchService {
    ProductBatchDTO getProductBatchDTO(int productBatch_id);

    List<ProductBatchDTO> getProductBatchDTOList();

    String createProductBatch(ProductBatchDTO productBatch);

    String updateProductBatch(ProductBatchDTO productBatch);
}
