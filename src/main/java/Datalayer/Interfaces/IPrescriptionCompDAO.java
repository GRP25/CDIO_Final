package Datalayer.Interfaces;

import Datalayer.DTO.PrescriptionCompDTO;
import java.util.ArrayList;

public interface IPrescriptionCompDAO {

	PrescriptionCompDTO getPrescriptionComp(int prescription_id);

	ArrayList<PrescriptionCompDTO> getPrescriptionCompList();

	ArrayList<PrescriptionCompDTO> getPrescriptionCompList(int prescription_id);

	void createPrescriptionComp(PrescriptionCompDTO prescription);

	void updatePrescriptionComp(PrescriptionCompDTO prescription);
}