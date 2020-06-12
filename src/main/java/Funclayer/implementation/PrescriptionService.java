package Funclayer.implementation;

import java.sql.SQLException;
import java.util.List;

import Datalayer.DAO.PrescriptionDAO;
import Datalayer.DTO.PrescriptionDTO;
import Datalayer.Interfaces.IPrescriptionDAO;
import Funclayer.interfaces.IPrescriptionService;

public class PrescriptionService implements IPrescriptionService {

	IPrescriptionDAO prescriptionDAO = new PrescriptionDAO();

	@Override
	public PrescriptionDTO getPrescription(int prescription_id) throws SQLException {
		return prescriptionDAO.getPrescription(prescription_id);
	}

	@Override
	public List<PrescriptionDTO> getPrescriptionList() throws SQLException {
		return prescriptionDAO.getPrescriptionList();
	}

	@Override
	public String createPrescription(PrescriptionDTO prescription) throws SQLException {
		prescriptionDAO.createPrescription(prescription);
		return "Insert query executed succesfully";
	}

	@Override
	public String updatePrescription(PrescriptionDTO prescription) throws SQLException {
		prescriptionDAO.updatePrescription(prescription);
		return "Update query executed succesfully";
	}
}