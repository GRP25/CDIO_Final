package Datalayer.DAO;

import java.util.ArrayList;

import javax.enterprise.context.RequestScoped;

import Datalayer.DTO.commodityDTO;
import Datalayer.Interfaces.ICommodityDAO;

@RequestScoped
public class CommodityDAO implements ICommodityDAO {

	@Override
	public commodityDTO getCommodity(int commodity_id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<commodityDTO> getCommodityList() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void createCommodity(commodityDTO commodity) {
		// TODO Auto-generated method stub

	}

	@Override
	public void updateCommodity(commodityDTO commodity) {
		// TODO Auto-generated method stub

	}

}