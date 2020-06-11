package Datalayer.Interfaces;
import java.util.List;

import Datalayer.DTO.commodityDTO;


public interface ICommodityDAO {

	commodityDTO getCommodity(int commodity_id);

	List<commodityDTO> getCommodityList();

	void createCommodity(commodityDTO commodity);

	void updateCommodity(commodityDTO commodity);

}