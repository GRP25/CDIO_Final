package Datalayer.DAO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.RequestScoped;

import DB.DBUtil;
import Datalayer.DTO.ProductBatchCompDTO;
import Datalayer.Interfaces.IProductBatchCompDAO;

/**
 * ProductBatchCompDAO
 */
@RequestScoped
public class ProductBatchCompDAO implements IProductBatchCompDAO {

	@Override
	public ProductBatchCompDTO getProductBatchComp(int productBatch_id, int commodityBatch_id) {
		String sql = "SELECT * FROM ProduktBatchComp WHERE productBatchId = ? AND WHERE commodityBatchId = ?";

		Object[] parameter = DBUtil.convertTOObject(productBatch_id, commodityBatch_id);
		ResultSet resultSet = DBUtil.executeSelectQuery(sql,parameter);

		ProductBatchCompDTO productBatchCompDTO;

		try{
			resultSet.first();
			productBatchCompDTO = (ProductBatchCompDTO) DBUtil.resultSetToObject(resultSet, ProductBatchCompDTO.class);
		}catch (SQLException e){
			e.printStackTrace();
			return null;
		}
		// TODO Auto-generated method stub
		return productBatchCompDTO;
	}

	@Override
	public List<ProductBatchCompDTO> getProductBatchCompList() {
		String sql = "SELECT * FROM ProduktBatchComp";

		ResultSet resultSet = DBUtil.executeSelectQuery(sql,null);
		List<ProductBatchCompDTO> productBatchCompDAOList;

		try{
			ProductBatchCompDTO productBatchCompDTO;
			productBatchCompDAOList = new ArrayList<>();
			while (resultSet.next()){
				productBatchCompDTO = (ProductBatchCompDTO) DBUtil.resultSetToObject(resultSet, ProductBatchCompDTO.class);
				productBatchCompDAOList.add(productBatchCompDTO);
			}
		}catch (SQLException e){
			e.printStackTrace();
			return null;
		}
		// TODO Auto-generated method stub
		return productBatchCompDAOList;
	}

	@Override
	public List<ProductBatchCompDTO> getProductBatchCompList(int productBatch_id) {

		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void createProductBatchComp(ProductBatchCompDTO productBatchComp) {
		String sql = "INSERT INTO  ProduktBatchComp (commodityId, userId, tara, netto) values (?, ?, ?, ?);";
		Object[] parameter = DBUtil.convertTOObject(productBatchComp);

		try{
			DBUtil.executeCreateAndUpdate(sql,parameter);
		}catch (SQLException e){
			e.printStackTrace();
		}
		// TODO Auto-generated method stub

	}

	@Override
	public void updateProductBatchComp(ProductBatchCompDTO productBatchComp) {
		String sql = "UPDATE ProduktBatchComp SET productBatchId = ?, commodityBatchId = ?, userId = ?, tara = ?, netto = ?";
		Object[] parameter = DBUtil.convertTOObject(productBatchComp);

		try{
			DBUtil.executeCreateAndUpdate(sql,parameter);
		}catch (SQLException e){
			e.printStackTrace();
		}
		// TODO Auto-generated method stub

	}

}