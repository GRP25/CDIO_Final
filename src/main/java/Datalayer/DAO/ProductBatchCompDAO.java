package Datalayer.DAO;

import java.util.ArrayList;

import javax.enterprise.context.RequestScoped;

import Datalayer.DTO.productBatchCompDTO;
import Datalayer.Interfaces.IProductBatchCompDAO;

/**
 * ProductBatchCompDAO
 */
@RequestScoped
public class ProductBatchCompDAO implements IProductBatchCompDAO {

	@Override
	public productBatchCompDTO getProductBatchComp(int productBatch_id, int commodityBatch_id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<productBatchCompDTO> getProductBatchCompList() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<productBatchCompDTO> getProductBatchCompList(int productBatch_id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void createProductBatchComp(productBatchCompDTO productBatchComp) {
		// TODO Auto-generated method stub

	}

	@Override
	public void updateProductBatchComp(productBatchCompDTO productBatchComp) {
		// TODO Auto-generated method stub

	}

}