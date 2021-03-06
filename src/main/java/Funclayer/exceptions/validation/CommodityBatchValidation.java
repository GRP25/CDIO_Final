package Funclayer.exceptions.validation;

import Datalayer.DAO.CommodityBatchDAO;
import Datalayer.DAO.CommodityDAO;
import Datalayer.DTO.CommodityBatchDTO;
import Datalayer.Interfaces.ICommodityBatchDAO;
import Datalayer.Interfaces.ICommodityDAO;
import Funclayer.exceptions.exceptions.IDException;
import Funclayer.exceptions.exceptions.ObjectException;
import Funclayer.exceptions.validation.template.Validation;

import java.sql.SQLException;

public class CommodityBatchValidation extends Validation {
    static ICommodityBatchDAO commodityBatchDAO = new CommodityBatchDAO();

    public static void validateCommodityBatchID(int ID) throws SQLException {
        if (ID == 0)
            throw new ObjectException("No CommodityBatch exists with this number as an identification!");
        if (!commodityBatchDAO.exists(idValidator(ID))) {
            throw new IDException("No CommodityBatch exists with this number as an identification!");
        }
    }

    public static void commodityBatchValidationForCreate(CommodityBatchDTO commodityBatchDTO) throws SQLException {
        ICommodityDAO commodityDAO = new CommodityDAO();
        if (commodityBatchDAO.exists(idValidator(commodityBatchDTO.getCommodityBatch_id())))
            throw new ObjectException("CommodityBatch id is already exist");
        if (!commodityDAO.exists(idValidator(commodityBatchDTO.getCommodity_id())))
            throw new ObjectException("Commodity id is not exist");
        if (!isDouble(commodityBatchDTO.getWeight()))
            throw new ObjectException("Invalid weight Please use just number");
        if (hasSpecial(commodityBatchDTO.getSupplier()))
            throw new ObjectException("Invalid Supplier (Out special character)");
    }

    public static void commodityBatchValidationForUpdate(CommodityBatchDTO commodityBatchDTO) throws SQLException {
        ICommodityDAO commodityDAO = new CommodityDAO();
        if (!commodityDAO.exists(idValidator(commodityBatchDTO.getCommodity_id())))
            throw new ObjectException("Commodity id is not exist");
        if (!isDouble(commodityBatchDTO.getWeight()))
            throw new ObjectException("Invalid weight Please use just number");
        if (hasSpecial(commodityBatchDTO.getSupplier()))
            throw new ObjectException("Invalid Supplier (Out special character)");
    }
}