package Funclayer.exceptions.validation;

import Datalayer.DAO.PrescriptionDAO;
import Datalayer.DTO.PrescriptionDTO;
import Datalayer.Interfaces.IPrescriptionDAO;
import Funclayer.exceptions.exceptions.DataLayerException;
import Funclayer.exceptions.exceptions.ObjectException;
import Funclayer.exceptions.validation.template.Validation;

import java.sql.SQLException;

public class PrescriptionValidation extends Validation {
    static IPrescriptionDAO prescriptionDAO = new PrescriptionDAO();

    public static void validatePrescriptionId(int id) throws SQLException {
        if (id == 0)
            throw new ObjectException("No Prescription exists with this number as an identification!");
        if (!prescriptionDAO.exists(id))
            throw new DataLayerException("No Prescription exists with this number as an identification!");
    }

    public static void prescriptionValidationForCreate(PrescriptionDTO prescriptionDTO) throws SQLException {
        idValidator(prescriptionDTO.getPrescription_id());
        if (prescriptionDAO.exists(prescriptionDTO.getPrescription_id()))
            throw new ObjectException("Prescription id is already exist");
        nameValidator(prescriptionDTO.getPrescription_name());
    }

    public static void prescriptionValidationForUpdate(PrescriptionDTO prescriptionDTO) throws SQLException {
        validatePrescriptionId(prescriptionDTO.getPrescription_id());
        nameValidator(prescriptionDTO.getPrescription_name());
    }
}