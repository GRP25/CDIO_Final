package Funclayer.implementation;

import Datalayer.DAO.ProductBatchDAO;
import Datalayer.DTO.ProductBatchDTO;
import Datalayer.Interfaces.IProductBatchDAO;
import Funclayer.exceptions.exceptions.NotProductBatchExeption;
import Funclayer.interfaces.IProductBatchService;

import java.sql.SQLException;
import java.util.List;

import static Funclayer.exceptions.validation.ProductBatchValidation.*;

public class ProductBatchService implements IProductBatchService {
    IProductBatchDAO productBatchDAO = new ProductBatchDAO();

    @Override
    public ProductBatchDTO getProductBatchDTO(int productBatch_id) throws SQLException {
        validateProductBatchID(productBatch_id);
        return productBatchDAO.getProductBatchDTO(productBatch_id);
    }

    @Override
    public List<ProductBatchDTO> getProductBatchDTOList() throws SQLException {
        return productBatchDAO.getProductBatchDTOList();
    }

    @Override
    public void createProductBatch(ProductBatchDTO productBatch) throws SQLException, NotProductBatchExeption {
        productBatchValidationForCreate(productBatch);
        productBatchDAO.createProductBatch(productBatch);
    }

    @Override
    public void updateProductBatch(ProductBatchDTO productBatch) throws SQLException, NotProductBatchExeption {
        productBatchValidationForUpdate(productBatch);
        if (productBatch.getStatus() == 1 || productBatch.getStatus() == 2) {
            productBatch.setEndDate(0);
        } else if (productBatch.getStatus() == 3) {
            productBatch.setEndDate(System.currentTimeMillis());
        }
        productBatchDAO.updateProductBatch(productBatch);
    }
}
