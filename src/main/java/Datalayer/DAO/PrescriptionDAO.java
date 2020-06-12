package Datalayer.DAO;

import java.util.ArrayList;

import javax.enterprise.context.RequestScoped;

import Datalayer.DTO.PrescriptionDTO;
import Datalayer.Interfaces.IPrescriptionDAO;

/**
 * PrescriptionDAO
 */
@RequestScoped
public class PrescriptionDAO implements IPrescriptionDAO {

	@Override
	public PrescriptionDTO getPrescription(int prescription_id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<PrescriptionDTO> getPrescriptionList() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void createPrescription(PrescriptionDTO prescription) {
		// TODO Auto-generated method stub
	}

	@Override
	public void updatePrescription(PrescriptionDTO prescription) {
		// TODO Auto-generated method stub
	}

}