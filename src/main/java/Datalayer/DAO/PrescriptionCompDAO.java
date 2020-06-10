package Datalayer.DAO;

import java.util.ArrayList;

import javax.enterprise.context.RequestScoped;

import Datalayer.DTO.PrescriptionCompDTO;
import Datalayer.Interfaces.IPrescriptionCompDAO;

/**
 * PrescriptionCompDAO
 */
@RequestScoped
public class PrescriptionCompDAO implements IPrescriptionCompDAO {

	@Override
	public PrescriptionCompDTO getPrescriptionComp(int prescription_id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<PrescriptionCompDTO> getPrescriptionCompList() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<PrescriptionCompDTO> getPrescriptionCompList(int prescription_id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void createPrescriptionComp(PrescriptionCompDTO prescription) {
		// TODO Auto-generated method stub

	}

	@Override
	public void updatePrescriptionComp(PrescriptionCompDTO prescription) {
		// TODO Auto-generated method stub

	}
}