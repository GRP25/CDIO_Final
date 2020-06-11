package Datalayer.Interfaces;

import java.util.List;

import Datalayer.DTO.PrescriptionDTO;

/**
 * IPrescriptionDAO
 */
public interface IPrescriptionDAO {

	PrescriptionDTO getPrescription(int prescription_id);

	List<PrescriptionDTO> getPrescriptionList();

	void createPrescription(PrescriptionDTO prescription);

	void updatePrescription(PrescriptionDTO prescription);
}