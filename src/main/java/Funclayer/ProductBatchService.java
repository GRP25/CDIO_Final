package Funclayer;

import Datalayer.DAO.ProductBatchDAO;
import Datalayer.DTO.ProductBatchDTO;
import Datalayer.Interfaces.IProductBatchDAO;

import java.util.List;

public class ProductBatchService implements IProductBatchService{

    IProductBatchDAO productBatchDAO = new ProductBatchDAO();

    @Override
    public ProductBatchDTO getProductBatchDTO(int productBatch_id) {
        return productBatchDAO.getProductBatchDTO(productBatch_id);
    }

    @Override
    public List<ProductBatchDTO> getProductBatchDTOList() {
        return productBatchDAO.getProductBatchDTOList();
    }

    @Override
    public String createProductBatch(ProductBatchDTO productBatch) {
        productBatchDAO.createProductBatch(productBatch);
        return "Insert query executed successfully";
    }

    @Override
    public String updateProductBatch(ProductBatchDTO productBatch) {
        productBatchDAO.updateProductBatch(productBatch);
        return "Update query executed successfully";
    }
}
