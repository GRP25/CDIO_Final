package REST.Services.Implementation;

import java.util.List;

import Datalayer.DAO.PrescriptionCompDAO;
import Datalayer.DTO.PrescriptionCompDTO;
import Datalayer.Interfaces.IPrescriptionCompDAO;
import REST.Services.Interfaces.IPrescriptionCompService;

public class PrescriptionCompService implements IPrescriptionCompService {

	IPrescriptionCompDAO prescriptionCompDAO = new PrescriptionCompDAO();

	@Override
	public PrescriptionCompDTO getPrescriptionComp(int prescription_id, int commodity_id) {
		return prescriptionCompDAO.getPrescriptionComp(prescription_id, commodity_id);
	}

	@Override
	public List<PrescriptionCompDTO> getPrescriptionCompList() {
		return prescriptionCompDAO.getPrescriptionCompList();
	}

	@Override
	public List<PrescriptionCompDTO> getPrescriptionCompList(int prescription_id) {
		return prescriptionCompDAO.getPrescriptionCompList(prescription_id);
	}

	@Override
	public String createPrescriptionComp(PrescriptionCompDTO prescription) {
		prescriptionCompDAO.createPrescriptionComp(prescription);
		return "Insert query executed succesfully";
	}

	@Override
	public String updatePrescriptionComp(PrescriptionCompDTO prescription) {
		prescriptionCompDAO.updatePrescriptionComp(prescription);
		return "Update query executed succesfully";
	}
}