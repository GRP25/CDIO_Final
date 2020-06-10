package Datalayer.Interfaces;

import Datalayer.DTO.prescriptionCompDTO;
import java.util.ArrayList;

interface IPrescriptionCompDAO {

	prescriptionCompDTO getPrescriptionComp(int prescription_id);

	ArrayList<prescriptionCompDTO> getPrescriptionCompList();

	ArrayList<prescriptionCompDTO> getPrescriptionCompList(int prescription_id);

	void createPrescriptionComp(prescriptionCompDTO prescription);

	void updatePrescriptionComp(prescriptionCompDTO prescription);
}