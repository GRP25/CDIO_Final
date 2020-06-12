package Funclayer.interfaces;

import Datalayer.DTO.PrescriptionDTO;

import java.sql.SQLException;
import java.util.List;

public interface IPrescriptionService {

	PrescriptionDTO getPrescription(int prescription_id) throws SQLException;

	List<PrescriptionDTO> getPrescriptionList() throws SQLException;

	String createPrescription(PrescriptionDTO prescription) throws SQLException;

	String updatePrescription(PrescriptionDTO prescription) throws SQLException;

}