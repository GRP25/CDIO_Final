package Datalayer.DAO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.RequestScoped;

import DB.DBUtil;
import Datalayer.DTO.PrescriptionDTO;
import Datalayer.Interfaces.IPrescriptionDAO;

/**
 * PrescriptionDAO
 */
@RequestScoped
public class PrescriptionDAO implements IPrescriptionDAO {

	@Override
	public PrescriptionDTO getPrescription(int prescription_id) {
		String query = "SELECT * FROM Prescription WHERE prescriptionId = ? ";
		Object[] parameter = DBUtil.convertTOObject(prescription_id);
		ResultSet resultSet = DBUtil.executeSelectQuery(query, parameter);

		PrescriptionDTO prescriptionDTO;

		try {
			resultSet.first();
			prescriptionDTO = (PrescriptionDTO) DBUtil.resultSetToObject(resultSet, PrescriptionDTO.class);
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		return prescriptionDTO;
	}

	@Override
	public List<PrescriptionDTO> getPrescriptionList() {
		String query = "SELECT * FROM Prescription";

		ResultSet resultSet = DBUtil.executeSelectQuery(query, null);
		List<PrescriptionDTO> prescriptionDTOList;

		try {
			PrescriptionDTO prescriptionDTO;
			prescriptionDTOList = new ArrayList<>();

			while (resultSet.next()) {
				prescriptionDTO = (PrescriptionDTO) DBUtil.resultSetToObject(resultSet, PrescriptionDTO.class);
				prescriptionDTOList.add(prescriptionDTO);
			}

		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		return prescriptionDTOList;
	}

	@Override
	public void createPrescription(PrescriptionDTO prescription) {
		String query = "INSERT INTO Prescription (prescriptionId, prescriptionName) VALUES (?, ?)";
		Object[] parameter = DBUtil.convertTOObject(prescription);

		try {
			DBUtil.executeCreateAndUpdate(query, parameter);
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	@Override
	public void updatePrescription(PrescriptionDTO prescription) {
		String query = "UPDATE Prescription SET prescriptionId = ?, prescriptionName =? WHERE prescriptionId = ?";
		Object[] parameter = DBUtil.convertTOObject(prescription);

		try {
			DBUtil.executeCreateAndUpdate(query, parameter);
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

}