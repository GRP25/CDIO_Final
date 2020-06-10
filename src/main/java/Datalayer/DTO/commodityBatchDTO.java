package Datalayer.DTO;

public class commodityBatchDTO {
	private int commodityBatch_id;
	private int commodity_id;
	private double weight;
	private String supplier;

	public commodityBatchDTO(int commodityBatch_id, int commodity_id, double weight, String supplier) {
		this.commodityBatch_id = commodityBatch_id;
		this.commodity_id = commodity_id;
		this.weight = weight;
		this.supplier = supplier;
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
}