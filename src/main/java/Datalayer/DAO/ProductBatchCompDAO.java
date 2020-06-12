package Datalayer.DAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Comparator;
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
    public ProductBatchCompDTO getProductBatchComp(int productBatch_id, int commodityBatch_id) throws SQLException {
        String query = "SELECT * FROM ProduktBatchComp WHERE productBatchId = ? AND WHERE commodityBatchId = ?";
        Connection connection = DBUtil.getConnection();
        Object[] parameter = DBUtil.convertTOObject(productBatch_id, commodityBatch_id);
        ResultSet resultSet = DBUtil.executeSelectQuery(query, parameter, connection);
        ProductBatchCompDTO productBatchCompDTO;


        resultSet.first();
        productBatchCompDTO = (ProductBatchCompDTO) DBUtil.resultSetToObject(resultSet, ProductBatchCompDTO.class);

        connection.close();

        // TODO Auto-generated method stub
        return productBatchCompDTO;
    }

    @Override
    public List<ProductBatchCompDTO> getProductBatchCompList() throws SQLException {
        String sql = "SELECT * FROM ProduktBatchComp";
        Connection connection = DBUtil.getConnection();
        ResultSet resultSet = DBUtil.executeSelectQuery(sql, null, connection);
        List<ProductBatchCompDTO> productBatchCompDAOList;

        ProductBatchCompDTO productBatchCompDTO;
        productBatchCompDAOList = new ArrayList<>();

        while (resultSet.next()) {
            productBatchCompDTO = (ProductBatchCompDTO) DBUtil.resultSetToObject(resultSet, ProductBatchCompDTO.class);
            productBatchCompDAOList.add(productBatchCompDTO);
        }

        connection.close();
        // TODO Auto-generated method stub
        return productBatchCompDAOList;
    }

    @Override
    public List<ProductBatchCompDTO> getProductBatchCompList(int productBatch_id) throws SQLException {
        String sql = "SELECT * FROM ProduktBatchComp WHERE productBatchId = ?";
        Connection connection = DBUtil.getConnection();
        Object[] parameter = DBUtil.convertTOObject(productBatch_id);
        ResultSet resultSet = DBUtil.executeSelectQuery(sql, parameter, connection);
        List<ProductBatchCompDTO> productBatchCompDTOList;

        ProductBatchCompDTO productBatchCompDTO;
        productBatchCompDTOList = new ArrayList<>();

        while (resultSet.next()) {
            productBatchCompDTO = (ProductBatchCompDTO) DBUtil.resultSetToObject(resultSet, ProductBatchCompDTO.class);
            productBatchCompDTOList.add(productBatchCompDTO);
        }

        connection.close();
        // TODO Auto-generated method stub
        return productBatchCompDTOList;
    }

    @Override
    public void createProductBatchComp(ProductBatchCompDTO productBatchComp) throws SQLException {
        String query = "INSERT INTO  ProduktBatchComp (productBatchId, commodityId, userId, tara, netto) values (?, ?, ?, ?, ?);";
        Object[] parameter = DBUtil.convertTOObject(productBatchComp);
        Connection connection = DBUtil.getConnection();

        DBUtil.executeSelectQuery(query, parameter, connection);
        connection.close();
        // TODO Auto-generated method stub
    }

    @Override
    public void updateProductBatchComp(ProductBatchCompDTO productBatchComp) throws SQLException {
        String sql = "UPDATE ProduktBatchComp SET productBatchId = ?, commodityBatchId = ?, userId = ?, tara = ?, netto = ?";
        Object[] parameter = DBUtil.convertTOObject(productBatchComp);
        Connection connection = DBUtil.getConnection();


        DBUtil.executeSelectQuery(sql, parameter, connection);
        connection.close();

        // TODO Auto-generated method stub

    }

}