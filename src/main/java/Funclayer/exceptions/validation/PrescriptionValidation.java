package Funclayer.exceptions.validation;

import Datalayer.DAO.PrescriptionDAO;
import Datalayer.DTO.PrescriptionDTO;
import Datalayer.Interfaces.IPrescriptionDAO;
import Funclayer.exceptions.exceptions.DataLayerException;
import Funclayer.exceptions.validation.template.Validation;

public class PrescriptionValidation extends Validation {

	public static void validatePrescription(PrescriptionDTO prescriptionDTO) {
		IPrescriptionDAO db = new PrescriptionDAO();
		if (db.exists(prescriptionDTO.getPrescription_id())){
			throw new DataLayerException("A prescription with this id already exists")
		}
	}
}