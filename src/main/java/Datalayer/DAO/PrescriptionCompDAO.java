package Datalayer.DAO;

import java.util.ArrayList;
import java.util.List;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.enterprise.context.RequestScoped;

import DB.DBUtil;
import Datalayer.DTO.PrescriptionCompDTO;
import Datalayer.Interfaces.IPrescriptionCompDAO;

/**
 * PrescriptionCompDAO
 */
@RequestScoped
public class PrescriptionCompDAO implements IPrescriptionCompDAO {

	@Override
	public PrescriptionCompDTO getPrescriptionComp(int prescription_id, int commodity_id) {
		String query = "SELECT * FROM prescriptionComp WHERE prescriptionId = ? AND commodityId = ?";
		Object[] parameter = DBUtil.convertTOObject(prescription_id, commodity_id);
		ResultSet resultSet = DBUtil.executeSelectQuery(query, parameter);

		PrescriptionCompDTO prescriptionCompDTO;

		try {
			resultSet.first();
			prescriptionCompDTO = (PrescriptionCompDTO) DBUtil.resultSetToObject(resultSet, PrescriptionCompDTO.class);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		return prescriptionCompDTO;
	}

	@Override
	public List<PrescriptionCompDTO> getPrescriptionCompList() {
		String query = "SELECT * FROM PrescriptionComp";

		ResultSet resultSet = DBUtil.executeSelectQuery(query, null);
		List<PrescriptionCompDTO> prescriptionCompList;

		try {
			PrescriptionCompDTO prescriptionCompDTO;
			prescriptionCompList = new ArrayList<>();
			while (resultSet.next()) {
				prescriptionCompDTO = (PrescriptionCompDTO) DBUtil.resultSetToObject(resultSet,
						PrescriptionCompDTO.class);
				prescriptionCompList.add(prescriptionCompDTO);
			}
			resultSet.first();
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		return prescriptionCompList;
	}

	@Override
	public List<PrescriptionCompDTO> getPrescriptionCompList(int prescription_id) {
		String query = "SELECT * FROM PrescriptionComp WHERE prescriptionId=?";
		Object[] parameter = DBUtil.convertTOObject(prescription_id);

		ResultSet resultSet = DBUtil.executeSelectQuery(query, parameter);
		List<PrescriptionCompDTO> prescriptionCompList;

		try {
			PrescriptionCompDTO prescriptionCompDTO;
			prescriptionCompList = new ArrayList<>();
			while (resultSet.next()) {
				prescriptionCompDTO = (PrescriptionCompDTO) DBUtil.resultSetToObject(resultSet,
						PrescriptionCompDTO.class);
				prescriptionCompList.add(prescriptionCompDTO);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		return prescriptionCompList;
	}

	@Override
	public void createPrescriptionComp(PrescriptionCompDTO prescription) {
		String query = "INSERT INTO PrescriptionComp (prescriptionId, commodityId, nomNetto, tolerance) VALUES (?,?,?,?)";
		Object[] parameter = DBUtil.convertTOObject(prescription);

		try {
			DBUtil.executeCreateAndUpdate(query, parameter);
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	@Override
	public void updatePrescriptionComp(PrescriptionCompDTO prescription) {
		String query = "UPDATE PrescriptionComp SET prescriptionId=?, commodityId=?, nomNetto=?, tolerance=? WHERE prescriptionId=? AND commodityId=?";
		Object[] parameter = DBUtil.convertTOObject(prescription);
		try {
			DBUtil.executeCreateAndUpdate(query, parameter);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}