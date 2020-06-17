package Datalayer.DTO;

import Datalayer.DTO.IDTO.IDTO;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ProductBatchCompDTO implements IDTO {
	private int productBatch_id;
	private int commodity_id;
	private int user_id;
	private double tara;
	private double netto;

	public ProductBatchCompDTO() {

	}

	public ProductBatchCompDTO(int productBatch_id, int commodity_id, int user_id, double tara, double netto) {
		this.productBatch_id = productBatch_id;
		this.commodity_id = commodity_id;
		this.user_id = user_id;
		this.tara = tara;
		this.netto = netto;
	}

	public void setProductBatch_id(int productBatch_id) {
		this.productBatch_id = productBatch_id;
	}

	public int getProductBatch_id() {
		return productBatch_id;
	}

	public void setCommodity_id(int commodity_id) {
		this.commodity_id = commodity_id;
	}

	public int getCommodity_id() {
		return commodity_id;
	}

	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}

	public int getUser_id() {
		return user_id;
	}

	public void setTara(double tara) {
		this.tara = tara;
	}

	public double getTara() {
		return tara;
	}

	public void setNetto(double netto) {
		this.netto = netto;
	}

	public double getNetto() {
		return netto;
	}

	@Override
	public String toString() {
		return "ProductBatchCompDTO{" + "productBatch_id=" + productBatch_id + ", commodity_id=" + commodity_id
				+ ", user_id=" + user_id + ", tara=" + tara + ", netto=" + netto + '}';
	}

	@Override
	public IDTO interpretResultSet(ResultSet resultSet) throws SQLException {
		this.setProductBatch_id(resultSet.getInt("productBatchId"));
		this.setCommodity_id(resultSet.getInt("commodityBatchId"));
		this.setUser_id(resultSet.getInt("userId"));
		this.setTara(resultSet.getDouble("tara"));
		this.setNetto(resultSet.getDouble("netto"));
		return null;
	}

	@Override
	public Object[] convertToObject() {
		Object[] objects = new Object[5];
		objects[0] = this.productBatch_id;
		objects[1] = this.commodity_id;
		objects[2] = this.user_id;
		objects[3] = this.tara;
		objects[4] = this.netto;
		return objects;
	}
}
