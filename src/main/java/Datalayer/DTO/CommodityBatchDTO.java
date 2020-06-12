package Datalayer.DTO;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CommodityBatchDTO {
	private int commodityBatch_id;
	private int commodity_id;
	private double weight;
	private String supplier;

	/** Default constructor for DBUtil.resultSetToObject purpose */
	public CommodityBatchDTO() {

	}

	public CommodityBatchDTO(int commodityBatch_id, int commodity_id, double weight, String supplier) {
		this.commodityBatch_id = commodityBatch_id;
		this.commodity_id = commodity_id;
		this.weight = weight;
		this.supplier = supplier;
	}

	public Object[] convertToObject() {
		Object[] objects = new Object[4];
		objects[0] = this.commodityBatch_id;
		objects[1] = this.commodity_id;
		objects[2] = this.weight;
		objects[3] = this.supplier;
		return objects;
	}

	public CommodityBatchDTO interpretResultSet(ResultSet resultSet) throws SQLException {
		this.setCommodity_id( resultSet.getInt( 1 ) );
		this.setCommodityBatch_id( resultSet.getInt( 2 ) );
		this.setWeight( resultSet.getDouble( 3 ) );
		this.setSupplier( resultSet.getString( 4 ) );
		return this;
	}


	public void setCommodityBatch_id(int commodityBatch_id) {
		this.commodityBatch_id = commodityBatch_id;
	}

	public int getCommodityBatch_id() {
		return commodityBatch_id;
	}

	public void setCommodity_id(int commodity_id) {
		this.commodity_id = commodity_id;
	}

	public int getCommodity_id() {
		return commodity_id;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}

	public double getWeight() {
		return weight;
	}

	public void setSupplier(String supplier) {
		this.supplier = supplier;
	}

	public String getSupplier() {
		return supplier;
	}

	@Override
	public String toString() {
		return "CommodityBatchDTO{" +
				"commodityBatch_id=" + commodityBatch_id +
				", commodity_id=" + commodity_id +
				", weight=" + weight +
				", supplier='" + supplier + '\'' +
				'}';
	}
}