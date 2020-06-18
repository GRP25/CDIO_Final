package Funclayer.implementation;

import Datalayer.DAO.ProductBatchCompDAO;
import Datalayer.DTO.ProductBatchCompDTO;
import Datalayer.Interfaces.IProductBatchCompDAO;
import Funclayer.exceptions.exceptions.ObjectException;
import Funclayer.interfaces.IProductBatchCompService;

import java.sql.SQLException;
import java.util.List;
import static Funclayer.exceptions.validation.ProductBatchCompValidation.*;


public class ProductBatchCompService implements IProductBatchCompService {

    IProductBatchCompDAO productBatchCompDAO = new ProductBatchCompDAO();

    @Override
    public ProductBatchCompDTO getProductBatchComp(int productBatch_id, int commodityBatch_id) throws SQLException {

        ProductBatchCompDTO productBatchCompDTO = productBatchCompDAO.getProductBatchComp(productBatch_id,commodityBatch_id);

        if (productBatchCompDTO.getProductBatch_id() == 0) // TODO how if commodity_batch doesn't exist
            throw new ObjectException("No ProductBatchComp or CommodityBatch exists with this number as an identification!");

        return productBatchCompDTO;

    }


    @Override
    public List<ProductBatchCompDTO> getProductBatchCompList() throws SQLException {
        return productBatchCompDAO.getProductBatchCompList();
    }


    @Override
    public List<ProductBatchCompDTO> getProductBatchCompList(int productBatch_id) throws SQLException {

        List<ProductBatchCompDTO> productBatchCompDTOList = productBatchCompDAO.getProductBatchCompList(productBatch_id);

        if (productBatchCompDTOList.isEmpty())
            throw new ObjectException("No ProductBatchComp exists with this ProductBatch ID");

        return productBatchCompDTOList;

    }


    @Override
    public String createProductBatchComp(ProductBatchCompDTO productBatchComp) throws SQLException {
        productBatchCompValidation(productBatchComp);
        productBatchCompDAO.createProductBatchComp(productBatchComp);
        return "Insert query executed successfully";
    }


    @Override
    public String updateProductBatchComp(ProductBatchCompDTO productBatchComp) throws SQLException {
        productBatchCompValidation(productBatchComp);
        productBatchCompDAO.updateProductBatchComp(productBatchComp);
        return "Update query executed successfully";
    }
}
