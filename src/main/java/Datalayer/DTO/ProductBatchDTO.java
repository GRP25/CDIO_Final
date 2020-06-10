package Datalayer.DTO;

public class productBatchDTO {
	private int productBatch_id;
	private int prescription_id;
	private int status;

	public productBatchDTO(int productBatch_id, int prescription_id, int status) {
		this.productBatch_id = productBatch_id;
		this.prescription_id = prescription_id;
		this.status = status;
	}

	public void setProductBatch_id(int productBatch_id) {
		this.productBatch_id = productBatch_id;
	}

	public int getProductBatch_id() {
		return productBatch_id;
	}

	public void setPrescription_id(int prescription_id) {
		this.prescription_id = prescription_id;
	}

	public int getPrescription_id() {
		return prescription_id;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public int getStatus() {
		return status;
	}

}
