package Datalayer.DTO;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CommodityDTO {
	private int commodity_id;
	private String commodity_Name;

	public CommodityDTO() {
	}

	public CommodityDTO(int commodity_id, String commodity_Name) {
		this.commodity_id = commodity_id;
		this.commodity_Name = commodity_Name;
	}

	public Object[] convertToObject() {
		Object[] object = new Object[2];
		object[0] = this.commodity_id;
		object[1] = this.commodity_Name;
		return object;
	}

	public CommodityDTO interpretResultSet(ResultSet resultSet) throws SQLException {
		this.setCommodity_id(resultSet.getInt(1));
		this.setCommodity_Name(resultSet.getString(2));
		return this;
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

	@Override
	public String toString() {
		return "commodityDTO{" +
				"commodity_id=" + commodity_id +
				", commodity_Name='" + commodity_Name + '\'' +
				'}';
	}
}