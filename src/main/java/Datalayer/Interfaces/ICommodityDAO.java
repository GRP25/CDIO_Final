package Datalayer.Interfaces;
import java.sql.SQLException;
import java.util.List;

import Datalayer.DTO.CommodityDTO;


public interface ICommodityDAO {

	CommodityDTO getCommodity(int commodity_id) throws SQLException;

	List<CommodityDTO> getCommodityList() throws SQLException;

	void createCommodity(CommodityDTO commodity) throws SQLException;

	void updateCommodity(CommodityDTO commodity) throws SQLException;

	boolean exists(int id) throws SQLException;


}