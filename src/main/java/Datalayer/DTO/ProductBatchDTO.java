package Datalayer.DTO;

import Datalayer.DTO.IDTO.IDTO;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ProductBatchDTO implements IDTO {
	private int productBatch_id;
	private int prescription_id;
	private Date startDate;
	private Date endDate;
	private int status;

	public ProductBatchDTO(int productBatch_id, int prescription_id, int status) {
		this.productBatch_id = productBatch_id;
		this.prescription_id = prescription_id;
		this.status = status;
	}

	public ProductBatchDTO() {

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

	public void setStartDate(Date date) {
		this.startDate = date;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setEndDate(Date date) {
		this.endDate = date;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public int getStatus() {
		return status;
	}

	@Override
	public IDTO interpretResultSet(ResultSet resultSet) throws SQLException {
		this.setProductBatch_id(resultSet.getInt("productBatchId"));
		this.setPrescription_id(resultSet.getInt("prescriptionId"));
		this.setStartDate(resultSet.getDate("startDate"));
		this.setEndDate(resultSet.getDate("endDate"));
		this.setStatus(resultSet.getInt("status"));
		return this;
	}

	@Override
	public Object[] convertToObject() {
		Object[] object = new Object[3];
		object[0] = this.productBatch_id;
		object[1] = this.prescription_id;
		object[2] = this.status;
		return object;
	}
}
