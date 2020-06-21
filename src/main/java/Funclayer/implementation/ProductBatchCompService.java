package Funclayer.implementation;

import Datalayer.DAO.ProductBatchCompDAO;
import Datalayer.DTO.ProductBatchCompDTO;
import Datalayer.Interfaces.IProductBatchCompDAO;
import Funclayer.exceptions.exceptions.ObjectException;
import Funclayer.interfaces.IProductBatchCompService;

import java.sql.SQLException;
import java.util.List;

import static Funclayer.exceptions.validation.CommodityBatchValidation.validateCommodityBatchID;
import static Funclayer.exceptions.validation.ProductBatchCompValidation.*;

public class ProductBatchCompService implements IProductBatchCompService {
    IProductBatchCompDAO productBatchCompDAO = new ProductBatchCompDAO();

    @Override
    public ProductBatchCompDTO getProductBatchComp(int productBatch_id, int commodityBatch_id) throws SQLException {
        productBatchCompValidationForID(productBatch_id);
        validateCommodityBatchID(commodityBatch_id);
        return productBatchCompDAO.getProductBatchComp(productBatch_id, commodityBatch_id);
    }

    @Override
    public List<ProductBatchCompDTO> getProductBatchCompList() throws SQLException {
        return productBatchCompDAO.getProductBatchCompList();
    }

    @Override
    public List<ProductBatchCompDTO> getProductBatchCompList(int productBatch_id) throws SQLException {
        List<ProductBatchCompDTO> productBatchCompDTOList;
        productBatchCompDTOList = productBatchCompDAO.getProductBatchCompList(productBatch_id);
        if (productBatchCompDTOList.isEmpty())
            throw new ObjectException("No ProductBatchComp exists with this ProductBatch ID");
        return productBatchCompDTOList;
    }

    @Override
    public void createProductBatchComp(ProductBatchCompDTO productBatchComp) throws SQLException {
        productBatchCompValidationForCreate(productBatchComp);
        productFinishedValidation(productBatchComp);
        productBatchCompDAO.createProductBatchComp(productBatchComp);
    }

    @Override
    public void updateProductBatchComp(ProductBatchCompDTO productBatchComp) throws SQLException {
        productBatchCompValidationForUpdate(productBatchComp);
        productFinishedValidation(productBatchComp);
        productBatchCompDAO.updateProductBatchComp(productBatchComp);
    }
}
