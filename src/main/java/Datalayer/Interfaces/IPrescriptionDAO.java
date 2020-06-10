package Datalayer.Interfaces;

import java.util.ArrayList;

import Datalayer.DTO.PrescriptionDTO;

/**
 * IPrescriptionDAO
 */
public interface IPrescriptionDAO {

	PrescriptionDTO getPrescription(int prescription_id);

	ArrayList<PrescriptionDTO> getPrescriptionList();

	void createPrescription(PrescriptionDTO prescription);

	void updatePrescription(PrescriptionDTO prescription);
}