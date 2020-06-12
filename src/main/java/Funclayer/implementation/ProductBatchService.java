package Funclayer.implementation;

import Datalayer.DAO.ProductBatchDAO;
import Datalayer.DTO.ProductBatchDTO;
import Datalayer.Interfaces.IProductBatchDAO;
import Funclayer.interfaces.IProductBatchService;

import java.sql.SQLException;
import java.util.List;

public class ProductBatchService implements IProductBatchService {

    IProductBatchDAO productBatchDAO = new ProductBatchDAO();

    @Override
    public ProductBatchDTO getProductBatchDTO(int productBatch_id) throws SQLException {
        return productBatchDAO.getProductBatchDTO(productBatch_id);
    }

    @Override
    public List<ProductBatchDTO> getProductBatchDTOList() throws SQLException {
        return productBatchDAO.getProductBatchDTOList();
    }

    @Override
    public String createProductBatch(ProductBatchDTO productBatch) throws SQLException {
        productBatchDAO.createProductBatch(productBatch);
        return "Insert query executed successfully";
    }

    @Override
    public String updateProductBatch(ProductBatchDTO productBatch) throws SQLException {
        productBatchDAO.updateProductBatch(productBatch);
        return "Update query executed successfully";
    }
}
