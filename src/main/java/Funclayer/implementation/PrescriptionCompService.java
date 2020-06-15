package Funclayer.implementation;

import java.sql.SQLException;
import java.util.List;

import Datalayer.DAO.PrescriptionCompDAO;
import Datalayer.DTO.PrescriptionCompDTO;
import Datalayer.Interfaces.IPrescriptionCompDAO;
import Funclayer.interfaces.IPrescriptionCompService;

public class PrescriptionCompService implements IPrescriptionCompService {

	IPrescriptionCompDAO prescriptionCompDAO = new PrescriptionCompDAO();

	@Override
	public PrescriptionCompDTO getPrescriptionComp(int prescription_id, int commodity_id) throws SQLException {
		return prescriptionCompDAO.getPrescriptionComp(prescription_id, commodity_id);
	}

	@Override
	public List<PrescriptionCompDTO> getPrescriptionCompList() throws SQLException {
		return prescriptionCompDAO.getPrescriptionCompList();
	}

	@Override
	public List<PrescriptionCompDTO> getPrescriptionCompList(int prescription_id) throws SQLException {
		return prescriptionCompDAO.getPrescriptionCompList(prescription_id);
	}

	@Override
	public String createPrescriptionComp(PrescriptionCompDTO prescription) throws SQLException {
		prescriptionCompDAO.createPrescriptionComp(prescription);
		return "Insert query executed successfully";
	}

	@Override
	public String updatePrescriptionComp(PrescriptionCompDTO prescription) throws SQLException {
		prescriptionCompDAO.updatePrescriptionComp(prescription);
		return "Update query executed successfully";
	}
}