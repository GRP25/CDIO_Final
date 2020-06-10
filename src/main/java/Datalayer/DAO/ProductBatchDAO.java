package Datalayer.DAO;

import java.util.ArrayList;

import javax.enterprise.context.RequestScoped;

import Datalayer.DTO.ProductBatchDTO;
import Datalayer.Interfaces.IProductBatchDAO;

/**
 * ProductBatchDAO
 */
@RequestScoped
public class ProductBatchDAO implements IProductBatchDAO {

	@Override
	public ProductBatchDTO getProductBatchDTO(int productBatch_id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<ProductBatchDTO> getProductBatchDTOList() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void createProductBatch(ProductBatchDTO productBatch) {
		// TODO Auto-generated method stub

	}

	@Override
	public void updateProductBatch(ProductBatchDTO productBatch) {
		// TODO Auto-generated method stub

	}

}