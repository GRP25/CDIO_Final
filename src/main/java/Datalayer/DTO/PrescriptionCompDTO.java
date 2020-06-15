package Datalayer.DTO;

import java.lang.reflect.Constructor;
import java.sql.ResultSet;
import java.sql.SQLException;

import Datalayer.DTO.IDTO.IDTO;

public class PrescriptionCompDTO implements IDTO {
	private int prescription_id;
	private int commodity_id;
	private double nomNetto;
	private double tolerance;

	public PrescriptionCompDTO() {

	}

	public PrescriptionCompDTO(int prescription_id, int commodity_id, double nomNetto, double tolerance) {
		this.prescription_id = prescription_id;
		this.commodity_id = commodity_id;
		this.nomNetto = nomNetto;
		this.tolerance = tolerance;
	}

	@Override
	public Object[] convertToObject() {
		Object[] object = new Object[4];
		object[0] = this.prescription_id;
		object[1] = this.commodity_id;
		object[2] = this.nomNetto;
		object[3] = this.tolerance;
		return object;
	}

	@Override
	public IDTO interpretResultSet(ResultSet resultSet) throws SQLException {
		this.setPrescription_id(resultSet.getInt(1));
		this.setCommodity_id(resultSet.getInt(2));
		this.setNomNetto(resultSet.getDouble(3));
		this.setTolerance(resultSet.getDouble(4));
		return this;
	}

	public void setPrescription_id(int prescription_id) {
		this.prescription_id = prescription_id;
	}

	public int getPrescription_id() {
		return prescription_id;
	}

	public void setCommodity_id(int commodity_id) {
		this.commodity_id = commodity_id;
	}

	public int getCommodity_id() {
		return commodity_id;
	}

	public void setNomNetto(double nomNetto) {
		this.nomNetto = nomNetto;
	}

	public double getNomNetto() {
		return nomNetto;
	}

	public void setTolerance(double tolerance) {
		this.tolerance = tolerance;
	}

	public double getTolerance() {
		return tolerance;
	}

	@Override
	public String toString() {
		return "PrescriptionCompDTO{" + "prescription_id=" + prescription_id + ", commodity_id=" + commodity_id
				+ ", nomNetto=" + nomNetto + ", tolerance=" + tolerance + '}';
	}
}
