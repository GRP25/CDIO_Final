package REST.Services.Interfaces;

import Datalayer.DTO.PrescriptionCompDTO;

import java.sql.SQLException;
import java.util.List;

public interface IPrescriptionCompService {

	PrescriptionCompDTO getPrescriptionComp(int prescription_id, int commodity_id) throws SQLException;

	List<PrescriptionCompDTO> getPrescriptionCompList() throws SQLException;

	List<PrescriptionCompDTO> getPrescriptionCompList(int prescription_id) throws SQLException;

	String createPrescriptionComp(PrescriptionCompDTO prescription) throws SQLException;

	String updatePrescriptionComp(PrescriptionCompDTO prescription) throws SQLException;
}