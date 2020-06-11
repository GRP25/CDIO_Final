package Datalayer.Interfaces;

import Datalayer.DTO.PrescriptionCompDTO;
import java.util.List;

public interface IPrescriptionCompDAO {

	PrescriptionCompDTO getPrescriptionComp(int prescription_id, int commodity_id);

	List<PrescriptionCompDTO> getPrescriptionCompList();

	List<PrescriptionCompDTO> getPrescriptionCompList(int prescription_id);

	void createPrescriptionComp(PrescriptionCompDTO prescription);

	void updatePrescriptionComp(PrescriptionCompDTO prescription);
}