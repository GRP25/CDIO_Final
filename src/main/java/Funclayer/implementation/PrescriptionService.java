package Funclayer.implementation;

import Datalayer.DAO.PrescriptionDAO;
import Datalayer.DTO.PrescriptionDTO;
import Datalayer.Interfaces.IPrescriptionDAO;
import Funclayer.interfaces.IPrescriptionService;

import java.sql.SQLException;
import java.util.List;

import static Funclayer.exceptions.validation.PrescriptionValidation.*;

public class PrescriptionService implements IPrescriptionService {

    IPrescriptionDAO prescriptionDAO = new PrescriptionDAO();

    @Override
    public PrescriptionDTO getPrescription(int prescription_id) throws SQLException {
        validatePrescriptionId(prescription_id);
        return prescriptionDAO.getPrescription(prescription_id);
    }

    @Override
    public List<PrescriptionDTO> getPrescriptionList() throws SQLException {
        return prescriptionDAO.getPrescriptionList();
    }

    @Override
    public void createPrescription(PrescriptionDTO prescription) throws SQLException {
        prescriptionValidationForCreate(prescription);
        prescriptionDAO.createPrescription(prescription);
    }

    @Override
    public void updatePrescription(PrescriptionDTO prescription) throws SQLException {
        prescriptionValidationForUpdate(prescription);
        prescriptionDAO.updatePrescription(prescription);
    }
}