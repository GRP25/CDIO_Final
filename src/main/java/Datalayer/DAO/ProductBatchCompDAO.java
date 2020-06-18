package Datalayer.DAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.RequestScoped;

import Datalayer.DBUtil;
import Datalayer.DTO.ProductBatchCompDTO;
import Datalayer.Interfaces.IProductBatchCompDAO;

/**
 * ProductBatchCompDAO
 */
@RequestScoped
public class ProductBatchCompDAO implements IProductBatchCompDAO {

    @Override
    public ProductBatchCompDTO getProductBatchComp(int productBatch_id, int commodityBatch_id) throws SQLException {
        String query = "SELECT * FROM ProductBatchComp WHERE productBatchId = ? AND commodityBatchId = ?";
        Connection connection = DBUtil.getConnection();
        Object[] parameter = { productBatch_id, commodityBatch_id };
        ResultSet resultSet = DBUtil.executeSelectQuery(query, parameter, connection);
        ProductBatchCompDTO productBatchCompDTO = new ProductBatchCompDTO();

        if (resultSet.next()) {
            productBatchCompDTO.interpretResultSet(resultSet);
        }

        connection.close();

        return productBatchCompDTO;
    }

    @Override
    public List<ProductBatchCompDTO> getProductBatchCompList() throws SQLException {
        String sql = "SELECT * FROM ProductBatchComp";
        Connection connection = DBUtil.getConnection();
        ResultSet resultSet = DBUtil.executeSelectQuery(sql, null, connection);
        List<ProductBatchCompDTO> productBatchCompDAOList;

        ProductBatchCompDTO productBatchCompDTO;
        productBatchCompDAOList = new ArrayList<>();

        while (resultSet.next()) {
            productBatchCompDTO = new ProductBatchCompDTO();
            productBatchCompDTO.interpretResultSet(resultSet);
            productBatchCompDAOList.add(productBatchCompDTO);
        }

        connection.close();
        return productBatchCompDAOList;
    }

    @Override
    public List<ProductBatchCompDTO> getProductBatchCompList(int productBatch_id) throws SQLException {
        String sql = "SELECT * FROM ProductBatchComp WHERE productBatchId = ?";
        Connection connection = DBUtil.getConnection();
        Object[] parameter = { productBatch_id };
        ResultSet resultSet = DBUtil.executeSelectQuery(sql, parameter, connection);
        List<ProductBatchCompDTO> productBatchCompDTOList;

        ProductBatchCompDTO productBatchCompDTO;
        productBatchCompDTOList = new ArrayList<>();

        while (resultSet.next()) {
            productBatchCompDTO = new ProductBatchCompDTO();
            productBatchCompDTO.interpretResultSet(resultSet);
            productBatchCompDTOList.add(productBatchCompDTO);
        }

        connection.close();
        return productBatchCompDTOList;
    }

    @Override
    public void createProductBatchComp(ProductBatchCompDTO productBatchComp) throws SQLException {
        String query = "INSERT INTO  ProductBatchComp (productBatchId, commodityBatchId, userId, tara, netto) values (?, ?, ?, ?, ?);";
        Object[] parameter = productBatchComp.convertToObject();
        Connection connection = DBUtil.getConnection();

        DBUtil.executeSelectQuery(query, parameter, connection);
        connection.close();
    }

    @Override
    public void updateProductBatchComp(ProductBatchCompDTO productBatchComp) throws SQLException {
        String sql = "UPDATE ProductBatchComp SET productBatchId = ?, commodityBatchId = ?, userId = ?, tara = ?, netto = ? WHERE productBatchId = "
                + productBatchComp.getProductBatch_id() + " AND commodityBatchId = "
                + productBatchComp.getCommodityBatch_id();
        Object[] parameter = productBatchComp.convertToObject();
        Connection connection = DBUtil.getConnection();

        DBUtil.executeSelectQuery(sql, parameter, connection);
        connection.close();

    }

    @Override
    public boolean exists(int id) throws SQLException {
        String query = "SELECT productBatchId FROM ProductBatchComp WHERE productBatchId = ?";
        Object[] parameter = { id };
        Connection connection = DBUtil.getConnection();
        ResultSet rs = DBUtil.executeSelectQuery(query, parameter, connection);

        connection.close();
        return rs.next();
    }


}