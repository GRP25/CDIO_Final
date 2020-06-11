package REST.Services.Implementation;

import java.util.List;

import Datalayer.DAO.PrescriptionDAO;
import Datalayer.DTO.PrescriptionDTO;
import Datalayer.Interfaces.IPrescriptionDAO;
import REST.Services.Interfaces.IPrescriptionService;

public class PrescriptionService implements IPrescriptionService {

	IPrescriptionDAO prescriptionDAO = new PrescriptionDAO();

	@Override
	public PrescriptionDTO getPrescription(int prescription_id) {
		return prescriptionDAO.getPrescription(prescription_id);
	}

	@Override
	public List<PrescriptionDTO> getPrescriptionList() {
		return prescriptionDAO.getPrescriptionList();
	}

	@Override
	public String createPrescription(PrescriptionDTO prescription) {
		prescriptionDAO.createPrescription(prescription);
		return "Insert query executed succesfully";
	}

	@Override
	public String updatePrescription(PrescriptionDTO prescription) {
		prescriptionDAO.updatePrescription(prescription);
		return "Update query executed succesfully";
	}
}