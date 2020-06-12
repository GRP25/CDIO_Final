package Funclayer;

import Datalayer.DTO.ProductBatchCompDTO;

import java.util.List;

public interface IProductBatchCompService {
    ProductBatchCompDTO getProductBatchComp(int productBatch_id, int commodityBatch_id);

    List<ProductBatchCompDTO> getProductBatchCompList();

    List<ProductBatchCompDTO> getProductBatchCompList(int productBatch_id);

    String createProductBatchComp(ProductBatchCompDTO productBatchComp);

    String updateProductBatchComp(ProductBatchCompDTO productBatchComp);
}
