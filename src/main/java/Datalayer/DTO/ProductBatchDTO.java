package Datalayer.DTO;

import Datalayer.DTO.IDTO.IDTO;
import org.apache.ibatis.jdbc.Null;

import javax.enterprise.context.RequestScoped;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;

@RequestScoped
public class ProductBatchDTO implements IDTO {
	private int productBatch_id;
	private int prescription_id;
	private long startDate = System.currentTimeMillis();
	private long endDate = 0;
	private int status;

	public ProductBatchDTO(int productBatch_id, int prescription_id, int status) {
		this.productBatch_id = productBatch_id;
		this.prescription_id = prescription_id;
		this.status = status;
	}

	public ProductBatchDTO() {

	}

	public ProductBatchDTO(int productBatch_id, int prescription_id, long startDate, long endDate, int status) {
		this.productBatch_id = productBatch_id;
		this.prescription_id = prescription_id;
		this.startDate = startDate;
		this.endDate = endDate;
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

	public void setStartDate(long date) {
		this.startDate = date;
	}

	public long getStartDate() {
		return startDate;
	}

	public void setEndDate(long date) {
		this.endDate = date;
	}

	public long getEndDate() {
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
		this.setStartDate(resultSet.getDate("startDate").getTime());
		this.setEndDate(resultSet.getDate("endDate").getTime());
		this.setStatus(resultSet.getInt("status"));
		return this;
	}

	@Override
	public Object[] convertToObject() {
		Object[] object = new Object[5];
		object[0] = this.productBatch_id;
		object[1] = this.prescription_id;
		object[2] = new Date(this.startDate);
		object[3] = new Date(this.endDate);
		object[4] = this.status;
		return object;
	}
}
