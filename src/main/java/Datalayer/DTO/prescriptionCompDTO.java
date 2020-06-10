package Datalayer.DTO;

public class PrescriptionCompDTO {
	private int prescription_id;
	private int commodity_id;
	private double nomNetto;
	private double tolerance;

	public PrescriptionCompDTO(int prescription_id, int commodity_id, double nomNetto, double tolerance) {
		this.prescription_id = prescription_id;
		this.commodity_id = commodity_id;
		this.nomNetto = nomNetto;
		this.tolerance = tolerance;
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

}