package Datalayer.DAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.RequestScoped;

import com.mysql.cj.protocol.Resultset;

import DB.DBUtil;
import Datalayer.DTO.ProductBatchDTO;
import Datalayer.Interfaces.IProductBatchDAO;

/**
 * ProductBatchDAO
 */
@RequestScoped
public class ProductBatchDAO implements IProductBatchDAO {

    @Override
    public ProductBatchDTO getProductBatchDTO(int productBatch_id) throws SQLException {
        // SELECT * FROM ProductBatch WHERE productBatchId = ?

        Connection connection = DBUtil.getConnection();
        ProductBatchDTO productDTO;
        String query = "SELECT * FROM ProductBatch WHERE productBatchId = ?";
        Object[] parameter = DBUtil.convertTOObject(productBatch_id);
        ResultSet result = DBUtil.executeSelectQuery(query, parameter, connection);

        result.first();
        productDTO = (ProductBatchDTO) DBUtil.resultSetToObject(result, ProductBatchDTO.class);
        connection.close();

        return productDTO;
    }

    @Override
    public List<ProductBatchDTO> getProductBatchDTOList() throws SQLException {
        // SELECT * FROM ProductBatch

        Connection connection = DBUtil.getConnection();
        List<ProductBatchDTO> productDTOList = new ArrayList<>();
        String query = "SELECT * FROM ProductBatch";
        ProductBatchDTO productDTOTemp;


        ResultSet result = DBUtil.executeSelectQuery(query, null, connection);

        while (result.next()) {
            productDTOTemp = (ProductBatchDTO) DBUtil.resultSetToObject(result, ProductBatchDTO.class);
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
        String query = "INSERT INTO ProductBatch VALUES (?,?,?,?,?)";
        Object[] parameter = DBUtil.convertTOObject(productBatch);
        DBUtil.executeSelectQuery(query, parameter, connection);
    }

    @Override
    public void updateProductBatch(ProductBatchDTO productBatch) throws SQLException {
        // TODO Auto-generated method stub
        // UPDATE ProductBatch SET prescriptionId = ?, startDate = ?, endDate = ?, status = ? WHERE productBatchId = ?

        String query = "UPDATE ProductBatch SET prescriptionId = ?, startDate = ?, endDate = ?, status = ? WHERE productBatchId = ?";
        Connection connection = DBUtil.getConnection();
        Object[] parameter = DBUtil.convertTOObject(productBatch);

        DBUtil.executeSelectQuery(query, parameter, connection);

    }

}