package Datalayer.DTO;

public class ProductBatchCompDTO {
	private int productBatch_id;
	private int commodity_id;
	private int user_id;
	private double tara;
	private double netto;

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

}
