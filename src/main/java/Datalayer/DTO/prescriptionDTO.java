package Datalayer.DTO;

public class prescriptionDTO {
	private int prescription_id;
	private String prescription_name;

	public prescriptionDTO(int prescription_id, String prescription_name) {
		this.prescription_id = prescription_id;
		this.prescription_name = prescription_name;
	}

	public void setPrescription_id(int prescription_id) {
		this.prescription_id = prescription_id;
	}

	public int getPrescription_id() {
		return prescription_id;
	}

	public void setPrescription_name(String prescription_name) {
		this.prescription_name = prescription_name;
	}

	public String getPrescription_name() {
		return prescription_name;
	}

}