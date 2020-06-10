package Datalayer.DAO;

import java.util.ArrayList;

import javax.enterprise.context.RequestScoped;

import Datalayer.DTO.commodityBatchDTO;
import Datalayer.Interfaces.ICommodityBatchDAO;

@RequestScoped
public class CommodityBatchDAO implements ICommodityBatchDAO {

	@Override
	public commodityBatchDTO getCommodityBatch(int commodityBatch_id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<commodityBatchDTO> getCommodityBatchList() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<commodityBatchDTO> getCommodityBatchList(int commodityBatch_id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void createCommodityBatch(commodityBatchDTO batch) {
		// TODO Auto-generated method stub

	}

	@Override
	public void updateCommodityBatch(commodityBatchDTO batch) {
		// TODO Auto-generated method stub

	}
}