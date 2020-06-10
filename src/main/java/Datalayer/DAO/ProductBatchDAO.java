package Datalayer.DAO;

import java.util.ArrayList;

import javax.enterprise.context.RequestScoped;

import Datalayer.DTO.productBatchDTO;
import Datalayer.Interfaces.IProductBatchDAO;

/**
 * ProductBatchDAO
 */
@RequestScoped
public class ProductBatchDAO implements IProductBatchDAO {

	@Override
	public productBatchDTO getProductBatchDTO(int productBatch_id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<productBatchDTO> getProductBatchDTOList() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void createProductBatch(productBatchDTO productBatch) {
		// TODO Auto-generated method stub

	}

	@Override
	public void updateProductBatch(productBatchDTO productBatch) {
		// TODO Auto-generated method stub

	}

}