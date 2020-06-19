package Datalayer.Interfaces;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Datalayer.DTO.PrescriptionDTO;

/**
 * IPrescriptionDAO
 */
public interface IPrescriptionDAO {

	PrescriptionDTO getPrescription(int prescription_id) throws SQLException;

	List<PrescriptionDTO> getPrescriptionList() throws SQLException;

	void createPrescription(PrescriptionDTO prescription) throws SQLException;

	void updatePrescription(PrescriptionDTO prescription) throws SQLException;

	boolean exists(int id) throws SQLException;

}