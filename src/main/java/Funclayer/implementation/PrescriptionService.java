package Funclayer.implementation;

import java.sql.SQLException;
import java.util.List;

import Datalayer.DAO.PrescriptionDAO;
import Datalayer.DTO.PrescriptionDTO;
import Datalayer.Interfaces.IPrescriptionDAO;
import Funclayer.exceptions.exceptions.ObjectException;
import Funclayer.interfaces.IPrescriptionService;

import static Funclayer.exceptions.validation.PrescriptionValidation.prescriptionValidation;

public class PrescriptionService implements IPrescriptionService {

	IPrescriptionDAO prescriptionDAO = new PrescriptionDAO();

	@Override
	public PrescriptionDTO getPrescription(int prescription_id) throws SQLException {
		PrescriptionDTO prescriptionDTO = prescriptionDAO.getPrescription(prescription_id);

		if (prescriptionDTO.getPrescription_id() == 0)
			throw new ObjectException("No Prescription exists with this number as an identification!");

		return prescriptionDTO;
	}

	@Override
	public List<PrescriptionDTO> getPrescriptionList() throws SQLException {
		return prescriptionDAO.getPrescriptionList();
	}

	@Override
	public String createPrescription(PrescriptionDTO prescription) throws SQLException {
		prescriptionValidation(prescription);
		prescriptionDAO.createPrescription(prescription);
		return "Insert query executed successfully";
	}

	@Override
	public String updatePrescription(PrescriptionDTO prescription) throws SQLException {
		prescriptionValidation(prescription);
		prescriptionDAO.updatePrescription(prescription);
		return "Update query executed successfully";
	}
}