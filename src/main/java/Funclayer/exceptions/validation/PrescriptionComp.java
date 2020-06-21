package Funclayer.exceptions.validation;

import Datalayer.DAO.CommodityDAO;
import Datalayer.DAO.PrescriptionCompDAO;
import Datalayer.DTO.PrescriptionCompDTO;
import Datalayer.Interfaces.ICommodityDAO;
import Datalayer.Interfaces.IPrescriptionCompDAO;
import Funclayer.exceptions.exceptions.IDException;
import Funclayer.exceptions.exceptions.ObjectException;
import Funclayer.exceptions.validation.template.Validation;

import java.sql.SQLException;

public class PrescriptionComp extends Validation {
    static IPrescriptionCompDAO prescriptionCompDAO = new PrescriptionCompDAO();

    public static void validatePrescriptionDAOId(int pre_id, int com_id) throws SQLException {
        idValidator(pre_id);
        idValidator(com_id);
        if (pre_id == 0)
            throw new ObjectException("No Prescription exists with this number as an identification!");
        if (com_id == 0)
            throw new ObjectException("No Commodity exists with this number as an identification!");
        if (!prescriptionCompDAO.exists(pre_id, com_id)) {
            throw new IDException("No PrescriptionComp exists for this prescription with this commodity!");
        }
    }

    public static void prescriptionCompValidationForCreate(PrescriptionCompDTO prescriptionCompDTO) throws SQLException {
        //Checking if the prescription component already exists in the database.
        if (prescriptionCompDAO.exists(prescriptionCompDTO.getPrescription_id(), prescriptionCompDTO.getCommodity_id()))
            throw new ObjectException("PrescriptionComp already exist");
        //Checking if the commodity exist in the database
        ICommodityDAO commodityDAO = new CommodityDAO();
        if (!commodityDAO.exists(prescriptionCompDTO.getCommodity_id()))
            throw new ObjectException("A commodity with this id doesn't exist");
        double nomNetto = prescriptionCompDTO.getNomNetto();
        if (!isDouble(nomNetto) || !isNomNettoValid(nomNetto))
            throw new ObjectException("Invalid nomNetto Please input number between (0.05 - 20.0)");
        double tolerance = prescriptionCompDTO.getTolerance();
        if (!isDouble(tolerance) || !isTolerance(tolerance))
            throw new ObjectException("Invalid tolerance please input number between (0.1 - 10.0)");
    }

    public static void prescriptionCompValidationForUpdate(PrescriptionCompDTO prescriptionCompDTO) throws SQLException {
        double nomNetto = prescriptionCompDTO.getNomNetto();
        if (!isDouble(nomNetto) || !isNomNettoValid(nomNetto))
            throw new ObjectException("Invalid nomNetto Please input number between (0.05 - 20.0)");
        double tolerance = prescriptionCompDTO.getTolerance();
        if (!isDouble(tolerance) || !isTolerance(tolerance))
            throw new ObjectException("Invalid tolerance please input number between (0.1 - 10.0)");
    }

    private static boolean isNomNettoValid(double nomNetto) {
        if (nomNetto < 0.05 || nomNetto > 20.0)
            return false;
        return true;
    }

    private static boolean isTolerance(double tolerance) {
        if (tolerance < 0.1 || tolerance > 10.0)
            return false;
        return true;
    }
}