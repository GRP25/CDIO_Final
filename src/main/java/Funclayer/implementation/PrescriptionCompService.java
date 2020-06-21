package Funclayer.implementation;

import Datalayer.DAO.PrescriptionCompDAO;
import Datalayer.DTO.PrescriptionCompDTO;
import Datalayer.Interfaces.IPrescriptionCompDAO;
import Funclayer.exceptions.exceptions.ObjectException;
import Funclayer.interfaces.IPrescriptionCompService;

import java.sql.SQLException;
import java.util.List;

import static Funclayer.exceptions.validation.CommodityValidation.validateCommodityID;
import static Funclayer.exceptions.validation.PrescriptionComp.*;

public class PrescriptionCompService implements IPrescriptionCompService {
    IPrescriptionCompDAO prescriptionCompDAO = new PrescriptionCompDAO();

    @Override
    public PrescriptionCompDTO getPrescriptionComp(int prescription_id, int commodity_id) throws SQLException {
        validatePrescriptionDAOId(prescription_id);
        validateCommodityID(commodity_id);
        return prescriptionCompDAO.getPrescriptionComp(prescription_id, commodity_id);
    }

    @Override
    public List<PrescriptionCompDTO> getPrescriptionCompList() throws SQLException {
        return prescriptionCompDAO.getPrescriptionCompList();
    }

    @Override
    public List<PrescriptionCompDTO> getPrescriptionCompList(int prescription_id) throws SQLException {
        List<PrescriptionCompDTO> prescriptionCompDTOList;
        prescriptionCompDTOList = prescriptionCompDAO.getPrescriptionCompList(prescription_id);
        if (prescriptionCompDTOList.isEmpty())
            throw new ObjectException("No PrescriptionComp exists with this number as an identification!");
        return prescriptionCompDTOList;
    }

    @Override
    public void createPrescriptionComp(PrescriptionCompDTO prescription) throws SQLException {
        prescriptionCompValidationForCreate(prescription);
        prescriptionCompDAO.createPrescriptionComp(prescription);
    }

    @Override
    public void updatePrescriptionComp(PrescriptionCompDTO prescription) throws SQLException {
        prescriptionCompValidationForUpdate(prescription);
        prescriptionCompDAO.updatePrescriptionComp(prescription);
    }
}