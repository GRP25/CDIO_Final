package Funclayer.implementation;
import Datalayer.DAO.ProductBatchDAO;
import Datalayer.DTO.ProductBatchDTO;
import Datalayer.Interfaces.IProductBatchDAO;
import Funclayer.exceptions.exceptions.NotProductBatchExeption;
import Funclayer.exceptions.exceptions.ObjectException;
import Funclayer.interfaces.IProductBatchService;
import java.sql.SQLException;
import java.util.List;
import static Funclayer.exceptions.validation.ProductBatchValidation.*;

public class ProductBatchService implements IProductBatchService {

    IProductBatchDAO productBatchDAO = new ProductBatchDAO();

    @Override
    public ProductBatchDTO getProductBatchDTO(int productBatch_id) throws SQLException {

        ProductBatchDTO productBatchDTO = productBatchDAO.getProductBatchDTO(productBatch_id);

        if (productBatchDTO.getProductBatch_id() == 0)
            throw new ObjectException("No ProductBatch exists with this ProductBatch ID");

        return productBatchDTO;

    }


    @Override
    public List<ProductBatchDTO> getProductBatchDTOList() throws SQLException {
        return productBatchDAO.getProductBatchDTOList();
    }


    @Override
    public String createProductBatch(ProductBatchDTO productBatch) throws SQLException, NotProductBatchExeption {
        productBatchValidation(productBatch);
        productBatchDAO.createProductBatch(productBatch);
        return "Insert query executed successfully";
    }


    @Override
    public String updateProductBatch(ProductBatchDTO productBatch) throws SQLException, NotProductBatchExeption {
        productBatchValidation(productBatch);
        productBatchDAO.updateProductBatch(productBatch);
        return "Update query executed successfully";
    }
}
