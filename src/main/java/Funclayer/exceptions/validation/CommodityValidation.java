package Funclayer.exceptions.validation;

import Datalayer.DAO.CommodityDAO;
import Datalayer.DTO.CommodityDTO;
import Datalayer.Interfaces.ICommodityDAO;
import Funclayer.exceptions.exceptions.IDException;
import Funclayer.exceptions.exceptions.NotANameException;
import Funclayer.exceptions.exceptions.ObjectException;
import Funclayer.exceptions.validation.template.Validation;

import java.sql.SQLException;

public class CommodityValidation extends Validation {

    static ICommodityDAO commodityDAO = new CommodityDAO();

    public static void validateCommodityID(int ID) throws SQLException {
        if(!commodityDAO.exists(idValidator( ID ))){
            throw new IDException("No Commodity exists with this number as an identification!");
        }
    }

    public static void commodityValidation(CommodityDTO commodityDTO) throws SQLException {

        if (commodityDAO.exists( idValidator( commodityDTO.getCommodity_id(  ) )) )
            throw new ObjectException( "Commodity id is already exist");

        nameValidator( commodityDTO.getCommodity_Name());

    }
}