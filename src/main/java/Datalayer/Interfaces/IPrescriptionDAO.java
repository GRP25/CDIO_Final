package Datalayer.Interfaces;

import java.util.ArrayList;

import Datalayer.DTO.prescriptionDTO;

/**
 * IPrescriptionDAO
 */
interface IPrescriptionDAO {

	prescriptionDTO getPrescription(int prescription_id);

	ArrayList<prescriptionDTO> getPrescriptionList();

	void createPrescription(prescriptionDTO prescription);

	void updatePrescription(prescriptionDTO prescription);
}