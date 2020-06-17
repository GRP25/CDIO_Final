package Funclayer.implementation;

import java.sql.SQLException;
import java.util.List;

import Datalayer.DAO.PrescriptionCompDAO;
import Datalayer.DTO.PrescriptionCompDTO;
import Datalayer.Interfaces.IPrescriptionCompDAO;
import Funclayer.exceptions.exceptions.ObjectException;
import Funclayer.interfaces.IPrescriptionCompService;

import static Funclayer.exceptions.validation.PrescriptionComp.prescriptionCompValidation;

public class PrescriptionCompService implements IPrescriptionCompService {

	IPrescriptionCompDAO prescriptionCompDAO = new PrescriptionCompDAO();

	@Override
	public PrescriptionCompDTO getPrescriptionComp(int prescription_id, int commodity_id) throws SQLException {
		PrescriptionCompDTO prescriptionCompDTO =  prescriptionCompDAO.getPrescriptionComp(prescription_id, commodity_id);

		if (prescriptionCompDTO.getPrescription_id() == 0)
			throw new ObjectException("No PrescriptionComp exists with this number as an identification!");

		return prescriptionCompDTO;
	}

	@Override
	public List<PrescriptionCompDTO> getPrescriptionCompList() throws SQLException {
		return prescriptionCompDAO.getPrescriptionCompList();
	}

	@Override
	public List<PrescriptionCompDTO> getPrescriptionCompList(int prescription_id) throws SQLException {
		List<PrescriptionCompDTO> prescriptionCompDTOList = prescriptionCompDAO.getPrescriptionCompList(prescription_id);

		if (prescriptionCompDTOList.isEmpty())
			throw new ObjectException("No PrescriptionComp exists with this number as an identification!");

		return prescriptionCompDTOList;
	}

	@Override
	public String createPrescriptionComp(PrescriptionCompDTO prescription) throws SQLException {
		prescriptionCompValidation(prescription);
		prescriptionCompDAO.createPrescriptionComp(prescription);
		return "Insert query executed successfully";
	}

	@Override
	public String updatePrescriptionComp(PrescriptionCompDTO prescription) throws SQLException {
		prescriptionCompValidation(prescription);
		prescriptionCompDAO.updatePrescriptionComp(prescription);
		return "Update query executed successfully";
	}
}