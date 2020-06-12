package Funclayer;

import Datalayer.DAO.ProductBatchCompDAO;
import Datalayer.DTO.ProductBatchCompDTO;
import Datalayer.Interfaces.IProductBatchCompDAO;

import java.util.List;

public class ProductBatchCompService implements IProductBatchCompService {

    IProductBatchCompDAO productBatchCompDAO = new ProductBatchCompDAO();

    @Override
    public ProductBatchCompDTO getProductBatchComp(int productBatch_id, int commodityBatch_id) {
        return productBatchCompDAO.getProductBatchComp(productBatch_id,commodityBatch_id);
    }

    @Override
    public List<ProductBatchCompDTO> getProductBatchCompList() {
        return productBatchCompDAO.getProductBatchCompList();
    }

    @Override
    public List<ProductBatchCompDTO> getProductBatchCompList(int productBatch_id) {
        return productBatchCompDAO.getProductBatchCompList(productBatch_id);
    }

    @Override
    public String createProductBatchComp(ProductBatchCompDTO productBatchComp) {
        productBatchCompDAO.createProductBatchComp(productBatchComp);
        return "Insert query executed successfully";
    }

    @Override
    public String updateProductBatchComp(ProductBatchCompDTO productBatchComp) {
        productBatchCompDAO.updateProductBatchComp(productBatchComp);
        return "Update query executed successfully";
    }
}
