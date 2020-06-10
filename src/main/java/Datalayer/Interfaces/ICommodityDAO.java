package Datalayer.Interfaces;

import java.util.ArrayList;

import Datalayer.DTO.commodityDTO;

interface ICommodityDAO {

	commodityDTO getCommodity(int commodity_id);

	ArrayList<commodityDTO> getCommodityList();

	void createCommodity(commodityDTO commodity);

	void updateCommodity(commodityDTO commodity);

}