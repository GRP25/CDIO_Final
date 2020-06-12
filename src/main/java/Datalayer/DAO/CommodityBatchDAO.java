package Datalayer.DAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.RequestScoped;

import DB.DBUtil;
import Datalayer.DTO.CommodityBatchDTO;
import Datalayer.Interfaces.ICommodityBatchDAO;

@RequestScoped
public class CommodityBatchDAO implements ICommodityBatchDAO {

	@Override
	public CommodityBatchDTO getCommodityBatch(int commodityBatch_id) throws SQLException {
        Connection connection = DBUtil.getConnection();

		String query = "SELECT * FROM CommodityBatch WHERE commodityBatchId = ?";
		Object[] parameters = DBUtil.convertTOObject( commodityBatch_id ); // Todo Think about this

			ResultSet resultSet = DBUtil.executeSelectQuery( query, parameters, connection );
			CommodityBatchDTO commodityBatchDTO = new CommodityBatchDTO( );
            resultSet.first(); //todo Test if need if statement

                    commodityBatchDTO.interpretResultSet( resultSet ) ;

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
        Object[] parameters = DBUtil.convertTOObject( commodity_id );

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

                DBUtil.executeCreateAndUpdate( query, parameters, connection );

        connection.close();
	}

	@Override
	public void updateCommodityBatch(CommodityBatchDTO batch) throws SQLException {
        Connection connection = DBUtil.getConnection();

        String query = "UPDATE CommodityBatch SET commodityBatchId=?, commodityId=?, weight=?, supplier=? WHERE commodityBatchId="+batch.getCommodityBatch_id();
        Object[] parameters = batch.convertToObject();

		        DBUtil.executeCreateAndUpdate( query, parameters, connection );

        connection.close();
	}
}