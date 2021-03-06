package Funclayer.exceptions.validation;

import Datalayer.DAO.CommodityDAO;
import Datalayer.DTO.CommodityDTO;
import Datalayer.Interfaces.ICommodityDAO;
import Funclayer.exceptions.exceptions.IDException;
import Funclayer.exceptions.exceptions.ObjectException;
import Funclayer.exceptions.validation.template.Validation;

import java.sql.SQLException;

public class CommodityValidation extends Validation {
    static ICommodityDAO commodityDAO = new CommodityDAO();

    public static void validateCommodityID(int ID) throws SQLException {
        if (ID == 0)
            throw new ObjectException("No Commodity exists with this number as an identification!");
        if (!commodityDAO.exists(idValidator(ID))) {
            throw new IDException("No Commodity exists with this number as an identification!");
        }
    }

    public static void commodityValidationForCreate(CommodityDTO commodityDTO) throws SQLException {
        if (commodityDAO.exists(idValidator(commodityDTO.getCommodity_id())))
            throw new ObjectException("Commodity id already exists");
        nameValidator(commodityDTO.getCommodity_Name());
    }


    public static void commodityValidationForUpdate(CommodityDTO commodityDTO) throws SQLException {
        nameValidator(commodityDTO.getCommodity_Name());
    }
}