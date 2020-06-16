package Datalayer.Interfaces;
import java.sql.SQLException;
import java.util.List;

import Datalayer.DTO.commodityDTO;


public interface ICommodityDAO {

	commodityDTO getCommodity(int commodity_id) throws SQLException;

	List<commodityDTO> getCommodityList() throws SQLException;

	void createCommodity(commodityDTO commodity) throws SQLException;

	void updateCommodity(commodityDTO commodity) throws SQLException;

	boolean exists(int id) throws SQLException;


}