package Funclayer.exceptions.validation;

import Datalayer.DAO.CommodityBatchDAO;
import Datalayer.DAO.ProductBatchCompDAO;
import Datalayer.DAO.ProductBatchDAO;
import Datalayer.DAO.UserDAO;
import Datalayer.DTO.ProductBatchCompDTO;
import Datalayer.Interfaces.ICommodityBatchDAO;
import Datalayer.Interfaces.IProductBatchCompDAO;
import Datalayer.Interfaces.IProductBatchDAO;
import Datalayer.Interfaces.IUserDAO;
import Funclayer.exceptions.exceptions.ObjectException;
import Funclayer.exceptions.exceptions.ProductFinishedException;
import Funclayer.exceptions.validation.template.Validation;

import java.sql.SQLException;

public class ProductBatchCompValidation extends Validation {
    static IProductBatchCompDAO productBatchCompDAO = new ProductBatchCompDAO();

    public static void productBatchCompValidationForCreate(ProductBatchCompDTO productBatchCompDTO) throws SQLException {
        IUserDAO userDAO = new UserDAO();
        if (!userDAO.exists(idValidator(productBatchCompDTO.getUser_id())))
            throw new ObjectException("User ID is not exist");
        ICommodityBatchDAO commodityBatchDAO = new CommodityBatchDAO();
        if (!commodityBatchDAO.exists(idValidator(productBatchCompDTO.getCommodityBatch_id())))
            throw new ObjectException("CommodityBatch id is not exist");
//        if (productBatchCompDAO.exists( idValidator( productBatchCompDTO.getProductBatch_id())))
//            throw new ObjectException( "ProductBatchComp id is already exist");
        if (!isDouble(productBatchCompDTO.getNetto()))
            throw new ObjectException("Invalid netto format: Use a double");
        if (!isDouble(productBatchCompDTO.getTara()))
            throw new ObjectException("Invalid tara format: Use a double");
    }

    public static void productBatchCompValidationForUpdate(ProductBatchCompDTO productBatchCompDTO) throws SQLException {
        IUserDAO userDAO = new UserDAO();
        if (!userDAO.exists(idValidator(productBatchCompDTO.getUser_id())))
            throw new ObjectException("User ID is not exist");
        if (!isDouble(productBatchCompDTO.getNetto()))
            throw new ObjectException("Invalid netto format: Use a double");
        if (!isDouble(productBatchCompDTO.getTara()))
            throw new ObjectException("Invalid tara format: Use a double");
    }

    public static void productFinishedValidation(ProductBatchCompDTO dto) throws SQLException {
        IProductBatchDAO dao    = new ProductBatchDAO();
        int              status = dao.getProductBatchDTO(dto.getProductBatch_id()).getStatus();
        if (status == 3) {
            throw new ProductFinishedException("The production of this pruductbatch is already marked 'complete'!");
        }
    }

    public static void productBatchCompValidationForID(int pro_id, int combat_id) throws SQLException {
        if (pro_id == 0)
            throw new ObjectException("No ProductBatchComp exists with this number as an identification!");
        if (combat_id == 0)
            throw new ObjectException("No CommodityBatch exists with this number as an identification!");
        if (!productBatchCompDAO.exists(pro_id, combat_id))
            throw new ObjectException(("No ProductBatchComponent in this ProductBatch with this Commodity"));
    }
}
