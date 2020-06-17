package Funclayer.implementation;

import Datalayer.DAO.ProductBatchCompDAO;
import Datalayer.DTO.ProductBatchCompDTO;
import Datalayer.Interfaces.IProductBatchCompDAO;
import Funclayer.interfaces.IProductBatchCompService;

import java.sql.SQLException;
import java.util.List;

public class ProductBatchCompService implements IProductBatchCompService {

    IProductBatchCompDAO productBatchCompDAO = new ProductBatchCompDAO();

    @Override
    public ProductBatchCompDTO getProductBatchComp(int productBatch_id, int commodityBatch_id) throws SQLException {
        return productBatchCompDAO.getProductBatchComp(productBatch_id,commodityBatch_id);
    }

    @Override
    public List<ProductBatchCompDTO> getProductBatchCompList() throws SQLException {
        return productBatchCompDAO.getProductBatchCompList();
    }

    @Override
    public List<ProductBatchCompDTO> getProductBatchCompList(int productBatch_id) throws SQLException {
        return productBatchCompDAO.getProductBatchCompList(productBatch_id);
    }

    @Override
    public String createProductBatchComp(ProductBatchCompDTO productBatchComp) throws SQLException {
        productBatchCompDAO.createProductBatchComp(productBatchComp);
        return "Insert query executed successfully";
    }

    @Override
    public String updateProductBatchComp(ProductBatchCompDTO productBatchComp) throws SQLException {
        productBatchCompDAO.updateProductBatchComp(productBatchComp);
        return "Update query executed successfully";
    }
}
