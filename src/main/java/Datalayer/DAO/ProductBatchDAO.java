package Datalayer.DAO;

import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.RequestScoped;

import Datalayer.DBUtil;
import Datalayer.DAO.Interfaces.IValidation;
import Datalayer.DTO.ProductBatchDTO;
import Datalayer.Interfaces.IProductBatchDAO;

/**
 * ProductBatchDAO
 */
@RequestScoped
public class ProductBatchDAO implements IProductBatchDAO, IValidation {

    @Override
    public ProductBatchDTO getProductBatchDTO(int productBatch_id) throws SQLException {
        // SELECT * FROM ProductBatch WHERE productBatchId = ?

        Connection connection = DBUtil.getConnection();
        ProductBatchDTO productDTO = new ProductBatchDTO();
        String query = "SELECT * FROM ProductBatch WHERE productBatchId = ?";
        Object[] parameter = { productBatch_id };
        ResultSet result = DBUtil.executeSelectQuery(query, parameter, connection);

        result.first();
        System.out.println(result.toString());
        productDTO.interpretResultSet(result);
        connection.close();

        return productDTO;
    }

    @Override
    public List<ProductBatchDTO> getProductBatchDTOList() throws SQLException {
        // SELECT * FROM ProductBatch

        Connection connection = DBUtil.getConnection();
        List<ProductBatchDTO> productDTOList = new ArrayList<>();
        String query = "SELECT * FROM ProductBatch";

        ResultSet result = DBUtil.executeSelectQuery(query, null, connection);
        ProductBatchDTO productDTOTemp;

        while (result.next()) {
            productDTOTemp = new ProductBatchDTO();
            productDTOTemp.interpretResultSet(result);
            productDTOList.add(productDTOTemp);
        }

        connection.close();
        return productDTOList;
    }

    @Override
    public void createProductBatch(ProductBatchDTO productBatch) throws SQLException {
        // TODO Auto-generated method stub
        // INSERT INTO ProductBatch VALUES (?,?,?,?,?)

        Connection connection = DBUtil.getConnection();
        String query = "INSERT INTO ProductBatch (productBatchId,prescriptionId,startDate,endDate,status) VALUES (?,?,?,?,?);";
        Object[] parameter = productBatch.convertToObject();

        DBUtil.executeSelectQuery(query, parameter, connection);

        connection.close();
    }

    @Override
    public void updateProductBatch(ProductBatchDTO productBatch) throws SQLException {
        // TODO Auto-generated method stub
        // UPDATE ProductBatch SET prescriptionId = ?, startDate = ?, endDate = ?,
        // status = ? WHERE productBatchId = ?

        String query = "UPDATE ProductBatch SET endDate = ?, status = ?  WHERE productBatchId = ?";
        Connection connection = DBUtil.getConnection();
        Object[] parameter = {productBatch.getEndDate(), productBatch.getStatus(), productBatch.getProductBatch_id()};

        DBUtil.executeSelectQuery(query, parameter, connection);

        connection.close();
    }

    @Override
    public boolean exists(int id) throws SQLException {
        String query = "SELECT productBatchId FROM ProductBatch WHERE productBatchId = ?";
        Object[] parameter = { id };
        Connection connection = DBUtil.getConnection();
        ResultSet rs = DBUtil.executeSelectQuery(query, parameter, connection);

        connection.close();
        return rs.next();
    }

}