
/*
package Datalayer.DAO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.enterprise.context.RequestScoped;

import com.mysql.cj.protocol.Resultset;

import DB.DBUtil;
import Datalayer.DTO.ProductBatchDTO;
import Datalayer.Interfaces.IProductBatchDAO;


  ProductBatchDAO

public class ProductBatchDAO implements IProductBatchDAO {

	@Override
	public ProductBatchDTO getProductBatchDTO(int productBatch_id) {
		// SELECT * FROM ProductBatch WHERE productBatchId = ?
		
		ProductBatchDTO productDTO;
		String query = "SELECT * FROM ProductBatch WHERE productBatchId = ?";
		ResultSet result = DBUtil.executeSelectQuery(query, DBUtil.convertTOObject(productBatch_id));

		try {
			result.first();
			productDTO = (ProductBatchDTO) DBUtil.resultSetToObject(result, ProductBatchDTO.class);
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}

		return productDTO;
	}

	@Override
	public ArrayList<ProductBatchDTO> getProductBatchDTOList() {
		// SELECT * FROM ProductBatch

		ArrayList<ProductBatchDTO> productDTOList = new ArrayList<>();
		String query = "SELECT * FROM ProductBatch";
		ProductBatchDTO productDTOTemp;

		try {
			ResultSet result = DBUtil.executeSelectQuery(query, null);
			
			while (result.next()) {
				productDTOTemp = (ProductBatchDTO) DBUtil.resultSetToObject(result, ProductBatchDTO.class);
				productDTOList.add(productDTOTemp);
			}
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}

		return productDTOList;
	}

	@Override
	public void createProductBatch(ProductBatchDTO productBatch) {

		// INSERT INTO ProductBatch VALUES (?,?,?,?,?)

		String query = "INSERT INTO ProductBatch VALUES (?,?,?,?,?)";

		Object[] parameter = DBUtil.convertTOObject(productBatch);

		try {
			DBUtil.executeCreateAndUpdate(query, parameter);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void updateProductBatch(ProductBatchDTO productBatch) {

		// UPDATE ProductBatch SET prescriptionId = ?, startDate = ?, endDate = ?, status = ? WHERE productBatchId = ?

		String query = "UPDATE ProductBatch SET prescriptionId = ?, startDate = ?, endDate = ?, status = ? WHERE productBatchId = ?";

		Object[] parameter = DBUtil.convertTOObject(productBatch);

		try {
			DBUtil.executeCreateAndUpdate(query, parameter);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}



 */