package Funclayer.exceptions.validation;

import Datalayer.DAO.PrescriptionDAO;
import Datalayer.DTO.PrescriptionDTO;
import Datalayer.Interfaces.IPrescriptionDAO;
import Funclayer.exceptions.exceptions.DataLayerException;
import Funclayer.exceptions.exceptions.ObjectException;
import Funclayer.exceptions.validation.template.Validation;

import java.sql.SQLException;

public class PrescriptionValidation extends Validation {

	static IPrescriptionDAO prescriptionDAO = new PrescriptionDAO();

	public static void validatePrescription(PrescriptionDTO prescriptionDTO) throws SQLException {
		if (prescriptionDAO.exists(prescriptionDTO.getPrescription_id())){
			throw new DataLayerException("A prescription with this id already exists");
		}
	}


	public static void prescriptionValidation(PrescriptionDTO prescriptionDTO) throws SQLException {

		if (prescriptionDAO.exists( idValidator( prescriptionDTO.getPrescription_id())))
			throw new ObjectException( "Prescription id is already exist");

		nameValidator( prescriptionDTO.getPrescription_name() );


	}
}