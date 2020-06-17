package Datalayer.DAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.RequestScoped;

import Datalayer.DBUtil;
import Datalayer.DAO.Interfaces.IValidation;
import Datalayer.DTO.PrescriptionDTO;
import Datalayer.Interfaces.IPrescriptionDAO;

/**
 * PrescriptionDAO
 */
@RequestScoped
public class PrescriptionDAO implements IPrescriptionDAO, IValidation {

	@Override
	public PrescriptionDTO getPrescription(int prescription_id) throws SQLException {
		String query = "SELECT * FROM Prescription WHERE prescriptionId = ? ";
		Connection connection = DBUtil.getConnection();
		Object[] parameter = { prescription_id };
		ResultSet resultSet = DBUtil.executeSelectQuery(query, parameter, connection);

		PrescriptionDTO prescriptionDTO = new PrescriptionDTO();

		if (resultSet.next()) {
			prescriptionDTO.interpretResultSet(resultSet);
		}

		connection.close();
		return prescriptionDTO;
	}

	@Override
	public List<PrescriptionDTO> getPrescriptionList() throws SQLException {
		String query = "SELECT * FROM Prescription";
		Connection connection = DBUtil.getConnection();

		ResultSet resultSet = DBUtil.executeSelectQuery(query, null, connection);
		List<PrescriptionDTO> prescriptionDTOList = new ArrayList<>();

		while (resultSet.next()) {
			PrescriptionDTO prescriptionDTO = new PrescriptionDTO();
			prescriptionDTO.interpretResultSet(resultSet);
			prescriptionDTOList.add(prescriptionDTO);
		}

		connection.close();
		return prescriptionDTOList;
	}

	@Override
	public void createPrescription(PrescriptionDTO prescription) throws SQLException {
		String query = "INSERT INTO Prescription (prescriptionId, prescriptionName) VALUES (?, ?)";
		Connection connection = DBUtil.getConnection();
		Object[] parameter = prescription.convertToObject();
		DBUtil.executeSelectQuery(query, parameter, connection);
		connection.close();

	}

	@Override
	public void updatePrescription(PrescriptionDTO prescription) throws SQLException {
		String query = "UPDATE Prescription SET prescriptionId = ?, prescriptionName =? WHERE prescriptionId ="
				+ prescription.getPrescription_id();
		Connection connection = DBUtil.getConnection();
		Object[] parameter = prescription.convertToObject();
		DBUtil.executeSelectQuery(query, parameter, connection);
		connection.close();
	}

	@Override
	public boolean exists(int id) throws SQLException {
		String query = "SELECT prescriptionId FROM Prescription WHERE prescriptionId = ?";
		Object[] parameter = { id };
		Connection connection = DBUtil.getConnection();
		ResultSet rs = DBUtil.executeSelectQuery(query, parameter, connection);

		connection.close();
		return rs.next();
	}

}