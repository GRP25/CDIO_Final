package Datalayer.DAO;

import java.util.ArrayList;
import java.util.List;
import java.sql.*;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.enterprise.context.RequestScoped;

import Datalayer.DBUtil;
import Datalayer.DTO.PrescriptionCompDTO;
import Datalayer.Interfaces.IPrescriptionCompDAO;

/**
 * PrescriptionCompDAO
 */
@RequestScoped
public class PrescriptionCompDAO implements IPrescriptionCompDAO {

	@Override
	public PrescriptionCompDTO getPrescriptionComp(int prescription_id, int commodity_id) throws SQLException {
		String query = "SELECT * FROM PrescriptionComp WHERE prescriptionId = ? AND commodityId = ?";
		Connection connection = DBUtil.getConnection();
		Object[] parameter = { prescription_id, commodity_id };
		ResultSet resultSet = DBUtil.executeSelectQuery(query, parameter, connection);

		PrescriptionCompDTO prescriptionCompDTO = new PrescriptionCompDTO();

		if (resultSet.next()) {
			prescriptionCompDTO.interpretResultSet(resultSet);

		}
		connection.close();
		return prescriptionCompDTO;
	}

	@Override
	public List<PrescriptionCompDTO> getPrescriptionCompList() throws SQLException {
		String query = "SELECT * FROM PrescriptionComp";
		Connection connection = DBUtil.getConnection();

		ResultSet resultSet = DBUtil.executeSelectQuery(query, null, connection);
		List<PrescriptionCompDTO> prescriptionCompList = new ArrayList<>();

		while (resultSet.next()) {
			PrescriptionCompDTO prescroptionCompDTO = new PrescriptionCompDTO();
			prescroptionCompDTO.interpretResultSet(resultSet);
			prescriptionCompList.add(prescroptionCompDTO);
		}
		connection.close();
		return prescriptionCompList;
	}

	@Override
	public List<PrescriptionCompDTO> getPrescriptionCompList(int prescription_id) throws SQLException {
		String query = "SELECT * FROM PrescriptionComp WHERE prescriptionId=?";
		Connection connection = DBUtil.getConnection();
		Object[] parameter = { prescription_id };

		ResultSet resultSet = DBUtil.executeSelectQuery(query, parameter, connection);
		List<PrescriptionCompDTO> prescriptionCompList = new ArrayList<>();

		while (resultSet.next()) {
			PrescriptionCompDTO prescriptionCompDTO = new PrescriptionCompDTO();
			prescriptionCompDTO.interpretResultSet(resultSet);
			prescriptionCompList.add(prescriptionCompDTO);
		}

		connection.close();
		return prescriptionCompList;
	}

	@Override
	public void createPrescriptionComp(PrescriptionCompDTO prescription) throws SQLException {
		String query = "INSERT INTO PrescriptionComp (prescriptionId, commodityId, nomNetto, tollerance) VALUES (?,?,?,?)";
		Connection connection = DBUtil.getConnection();
		Object[] parameter = prescription.convertToObject();
		DBUtil.executeSelectQuery(query, parameter, connection);
		connection.close();
	}

	@Override
	public void updatePrescriptionComp(PrescriptionCompDTO prescription) throws SQLException {
		String query = "UPDATE PrescriptionComp SET prescriptionId=?, commodityId=?, nomNetto=?, tolerance=? WHERE prescriptionId="
				+ prescription.getPrescription_id() + " AND commodityId=" + prescription.getCommodity_id();
		Connection connection = DBUtil.getConnection();
		Object[] parameter = prescription.convertToObject();
		DBUtil.executeSelectQuery(query, parameter, connection);
		connection.close();

	}


	@Override
	public boolean exists(int id) throws SQLException {
		String query = "SELECT prescriptionId FROM PrescriptionComp WHERE prescriptionId = ?";
		Object[] parameter = { id };
		Connection connection = DBUtil.getConnection();
		ResultSet rs = DBUtil.executeSelectQuery(query, parameter, connection);

		connection.close();
		return rs.next();
	}

}