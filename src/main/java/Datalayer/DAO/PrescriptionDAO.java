package Datalayer.DAO;

import java.util.ArrayList;

import javax.enterprise.context.RequestScoped;

import Datalayer.DTO.prescriptionDTO;
import Datalayer.Interfaces.IPrescriptionDAO;

/**
 * PrescriptionDAO
 */
@RequestScoped
public class PrescriptionDAO implements IPrescriptionDAO {

	@Override
	public prescriptionDTO getPrescription(int prescription_id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<prescriptionDTO> getPrescriptionList() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void createPrescription(prescriptionDTO prescription) {
		// TODO Auto-generated method stub

	}

	@Override
	public void updatePrescription(prescriptionDTO prescription) {
		// TODO Auto-generated method stub

	}

}