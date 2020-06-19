package Funclayer.exceptions.validation;

import Datalayer.DAO.CommodityBatchDAO;
import Datalayer.DAO.CommodityDAO;
import Datalayer.DAO.ProductBatchCompDAO;
import Datalayer.DAO.UserDAO;
import Datalayer.DTO.ProductBatchCompDTO;
import Datalayer.Interfaces.ICommodityBatchDAO;
import Datalayer.Interfaces.ICommodityDAO;
import Datalayer.Interfaces.IProductBatchCompDAO;
import Datalayer.Interfaces.IUserDAO;
import Funclayer.exceptions.exceptions.ObjectException;
import Funclayer.exceptions.validation.template.Validation;

import java.sql.SQLException;

import static Funclayer.exceptions.validation.CommodityValidation.commodityDAO;

public class ProductBatchCompValidation extends Validation {

    static IProductBatchCompDAO productBatchCompDAO = new ProductBatchCompDAO();

    public static void productBatchCompValidation(ProductBatchCompDTO productBatchCompDTO) throws SQLException {

        IUserDAO userDAO = new UserDAO();
        if (!userDAO.exists( idValidator( productBatchCompDTO.getUser_id())))
            throw new ObjectException(  "User ID is not exist");

        ICommodityBatchDAO commodityBatchDAO = new CommodityBatchDAO();
        if (!commodityBatchDAO.exists( idValidator( productBatchCompDTO.getCommodityBatch_id() ) ))
            throw new ObjectException( "CommodityBatch id is not exist" );

//        if (productBatchCompDAO.exists( idValidator( productBatchCompDTO.getProductBatch_id())))
//            throw new ObjectException( "ProductBatchComp id is already exist");
//
        if (!isDouble( productBatchCompDTO.getNetto()))
            throw new ObjectException( "Invalid netto format: Use a double");

        if (!isDouble( productBatchCompDTO.getTara()))
            throw new ObjectException( "Invalid tara format: Use a double");

    }


}
