package REST.Services.Interfaces;

import Datalayer.DTO.PrescriptionDTO;
import java.util.List;

public interface IPrescriptionService {

	PrescriptionDTO getPrescription(int prescription_id);

	List<PrescriptionDTO> getPrescriptionList();

	String createPrescription(PrescriptionDTO prescription);

	String updatePrescription(PrescriptionDTO prescription);

}