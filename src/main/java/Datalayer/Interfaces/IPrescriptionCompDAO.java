package Datalayer.Interfaces;

import Datalayer.DTO.PrescriptionCompDTO;

import java.sql.SQLException;
import java.util.List;

public interface IPrescriptionCompDAO {

	PrescriptionCompDTO getPrescriptionComp(int prescription_id, int commodity_id) throws SQLException;

	List<PrescriptionCompDTO> getPrescriptionCompList() throws SQLException;

	List<PrescriptionCompDTO> getPrescriptionCompList(int prescription_id) throws SQLException;

	void createPrescriptionComp(PrescriptionCompDTO prescription) throws SQLException;

	void updatePrescriptionComp(PrescriptionCompDTO prescription) throws SQLException;
}