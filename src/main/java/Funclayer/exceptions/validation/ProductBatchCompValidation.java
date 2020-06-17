package Funclayer.exceptions.validation;

import Datalayer.DAO.CommodityDAO;
import Datalayer.DAO.ProductBatchCompDAO;
import Datalayer.DAO.UserDAO;
import Datalayer.DTO.CommodityBatchDTO;
import Datalayer.DTO.ProductBatchCompDTO;
import Datalayer.DTO.UserDTO;
import Datalayer.Interfaces.ICommodityDAO;
import Datalayer.Interfaces.IProductBatchCompDAO;
import Datalayer.Interfaces.IUserDAO;
import Funclayer.exceptions.exceptions.DataLayerException;
import Funclayer.exceptions.exceptions.NotACPRException;
import Funclayer.exceptions.exceptions.ObjectException;
import Funclayer.exceptions.exceptions.UserException;
import Funclayer.exceptions.validation.template.Validation;

import java.sql.SQLException;

import static Funclayer.Conversion.nameConversion;

public class ProductBatchCompValidation extends Validation {

    static IProductBatchCompDAO productBatchCompDAO = new ProductBatchCompDAO();

    public static void productBatchCompValidation(ProductBatchCompDTO productBatchCompDTO) throws SQLException {

        if (!productBatchCompDAO.exists( idValidator( productBatchCompDTO.getUser_id())))
            throw new ObjectException( "Invalid user ID");

        ICommodityDAO commodityDAO = new CommodityDAO();
        if (!commodityDAO.exists( idValidator( productBatchCompDTO.getCommodity_id() ) ))
            throw new ObjectException( "Commodity id is not exist" );

        if (!productBatchCompDAO.exists( idValidator( productBatchCompDTO.getProductBatch_id())))
            throw new ObjectException( "Invalid product ID");

        if (!isDouble( productBatchCompDTO.getNetto()))
            throw new ObjectException( "Invalid netto format: Use a double");

        if (!isDouble( productBatchCompDTO.getTara()))
            throw new ObjectException( "Invalid tara format: Use a double");

    }


}
