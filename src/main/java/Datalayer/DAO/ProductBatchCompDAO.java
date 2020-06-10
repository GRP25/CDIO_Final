package Datalayer.DAO;

import java.util.ArrayList;

import javax.enterprise.context.RequestScoped;

import Datalayer.DTO.ProductBatchCompDTO;
import Datalayer.Interfaces.IProductBatchCompDAO;

/**
 * ProductBatchCompDAO
 */
@RequestScoped
public class ProductBatchCompDAO implements IProductBatchCompDAO {

	@Override
	public ProductBatchCompDTO getProductBatchComp(int productBatch_id, int commodityBatch_id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<ProductBatchCompDTO> getProductBatchCompList() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<ProductBatchCompDTO> getProductBatchCompList(int productBatch_id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void createProductBatchComp(ProductBatchCompDTO productBatchComp) {
		// TODO Auto-generated method stub

	}

	@Override
	public void updateProductBatchComp(ProductBatchCompDTO productBatchComp) {
		// TODO Auto-generated method stub

	}

}