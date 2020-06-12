package REST.Services.Interfaces;

import Datalayer.DTO.PrescriptionCompDTO;

import java.util.List;

public interface IPrescriptionCompService {

	PrescriptionCompDTO getPrescriptionComp(int prescription_id, int commodity_id);

	List<PrescriptionCompDTO> getPrescriptionCompList();

	List<PrescriptionCompDTO> getPrescriptionCompList(int prescription_id);

	String createPrescriptionComp(PrescriptionCompDTO prescription);

	String updatePrescriptionComp(PrescriptionCompDTO prescription);
}