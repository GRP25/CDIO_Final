package Datalayer.DAO;

import java.util.ArrayList;

import javax.enterprise.context.RequestScoped;

import Datalayer.DTO.prescriptionCompDTO;
import Datalayer.Interfaces.IPrescriptionCompDAO;

/**
 * PrescriptionCompDAO
 */
@RequestScoped
public class PrescriptionCompDAO implements IPrescriptionCompDAO {

	@Override
	public prescriptionCompDTO getPrescriptionComp(int prescription_id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<prescriptionCompDTO> getPrescriptionCompList() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<prescriptionCompDTO> getPrescriptionCompList(int prescription_id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void createPrescriptionComp(prescriptionCompDTO prescription) {
		// TODO Auto-generated method stub

	}

	@Override
	public void updatePrescriptionComp(prescriptionCompDTO prescription) {
		// TODO Auto-generated method stub

	}
}