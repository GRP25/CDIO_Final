package Datalayer.DTO;

public class commodityDTO {
	private int commodity_id;
	private String commodity_Name;

	public commodityDTO(int commodity_id, String commodity_Name) {
		this.commodity_id = commodity_id;
		this.commodity_Name = commodity_Name;
	}

	public void setCommodity_id(int commodity_id) {
		this.commodity_id = commodity_id;
	}

	public int getCommodity_id() {
		return commodity_id;
	}

	public void setCommodity_Name(String commodity_Name) {
		this.commodity_Name = commodity_Name;
	}

	public String getCommodity_Name() {
		return commodity_Name;
	}
}