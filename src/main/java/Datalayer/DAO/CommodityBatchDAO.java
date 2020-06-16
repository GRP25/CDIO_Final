package Datalayer.DAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.RequestScoped;

import Datalayer.DBUtil;
import Datalayer.DTO.CommodityBatchDTO;
import Datalayer.Interfaces.ICommodityBatchDAO;

@RequestScoped
public class CommodityBatchDAO implements ICommodityBatchDAO {

    @Override
    public CommodityBatchDTO getCommodityBatch(int commodityBatch_id) throws SQLException {
        Connection connection = DBUtil.getConnection();

        String query = "SELECT * FROM CommodityBatch WHERE commodityBatchId = ?";
        Object[] parameters = {commodityBatch_id}; // Todo Think about this

        ResultSet resultSet = DBUtil.executeSelectQuery( query, parameters, connection );
        CommodityBatchDTO commodityBatchDTO = new CommodityBatchDTO( );
        resultSet.first(); //todo Test if need if statement

        commodityBatchDTO.interpretResultSet( resultSet );

        connection.close();
        return commodityBatchDTO;
    }

    @Override
    public List<CommodityBatchDTO> getCommodityBatchList() throws SQLException {
        Connection connection = DBUtil.getConnection();

        String query = "SELECT * FROM CommodityBatch";

        ResultSet resultSet = DBUtil.executeSelectQuery( query, null, connection);
        List<CommodityBatchDTO> listOfCommodityBatchDTO = new ArrayList<>();

        CommodityBatchDTO commodityBatchDTO;

        while (resultSet.next()) {
            commodityBatchDTO = new CommodityBatchDTO( );
            commodityBatchDTO.interpretResultSet( resultSet );
            listOfCommodityBatchDTO.add(commodityBatchDTO);
        }

        connection.close();
        return listOfCommodityBatchDTO;
    }

    @Override
    public List<CommodityBatchDTO> getCommodityBatchList(int commodity_id) throws SQLException {
        Connection connection = DBUtil.getConnection();

        String query = "SELECT * FROM CommodityBatch WHERE commodityId = ?";
        Object[] parameters = {commodity_id};

        ResultSet resultSet = DBUtil.executeSelectQuery( query, parameters, connection );
        List<CommodityBatchDTO> listOfCommodityBatchDTO;

        CommodityBatchDTO commodityBatchDTO;
        listOfCommodityBatchDTO = new ArrayList<>();

        while (resultSet.next()) {
            commodityBatchDTO = new CommodityBatchDTO(  );
            commodityBatchDTO.interpretResultSet( resultSet );
            listOfCommodityBatchDTO.add( commodityBatchDTO );
        }

        connection.close();
        return listOfCommodityBatchDTO;
    }

    @Override
    public void createCommodityBatch(CommodityBatchDTO batch) throws SQLException {
        Connection connection = DBUtil.getConnection();

        String query = "INSERT INTO CommodityBatch (commodityBatchId, commodityId, weight, supplier) VALUES (?, ?, ?, ?)";
        Object[] parameters = batch.convertToObject();

        DBUtil.executeSelectQuery( query, parameters, connection );

        connection.close();
    }

    @Override
    public void updateCommodityBatch(CommodityBatchDTO batch) throws SQLException {
        Connection connection = DBUtil.getConnection();

        String query = "UPDATE CommodityBatch SET commodityBatchId=?, commodityId=?, weight=?, supplier=? WHERE commodityBatchId="+batch.getCommodityBatch_id();
        Object[] parameters = batch.convertToObject();

        DBUtil.executeSelectQuery( query, parameters, connection );
        connection.close();
    }

    @Override
    public boolean exists(int id) throws SQLException {
        boolean ret;
        String query = "SELECT commodityBatchId FROM CommodityBatch WHERE commodityBatchId = ?";
        Object[] parameter = { id };
        Connection connection = DBUtil.getConnection();
        ResultSet rs = DBUtil.executeSelectQuery(query, parameter, connection);
        if (rs.next())
            ret = true;
        else
            ret = false;
        connection.close();
        return ret;
    }
}