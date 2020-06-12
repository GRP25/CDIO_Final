/*package REST.Services.Implementation;

import Datalayer.DAO.CommodityBatchDAO;
import Datalayer.DTO.CommodityBatchDTO;
import Datalayer.Interfaces.ICommodityBatchDAO;
import REST.Services.Interfaces.ICommodityBatchService;

import java.sql.SQLException;
import java.util.List;

public class CommodityBatchService implements ICommodityBatchService {

    ICommodityBatchDAO commodityBatchDAO = new CommodityBatchDAO();

    @Override
    public CommodityBatchDTO getCommodityBatch(int commodityBatch_id) throws SQLException {
        return commodityBatchDAO.getCommodityBatch( commodityBatch_id );
    }

    @Override
    public List<CommodityBatchDTO> getCommodityBatchList() throws SQLException {
        return commodityBatchDAO.getCommodityBatchList();
    }

    @Override
    public List<CommodityBatchDTO> getCommodityBatchList(int commodityBatch_id) throws SQLException {
        return commodityBatchDAO.getCommodityBatchList( commodityBatch_id );
    }

    @Override
    public String createCommodityBatch(CommodityBatchDTO batch) throws SQLException {
        commodityBatchDAO.createCommodityBatch( batch );
        return "Insert query executed successfully";
    }

    @Override
    public String updateCommodityBatch(CommodityBatchDTO batch) throws SQLException {
        commodityBatchDAO.updateCommodityBatch( batch );
        return "Update query executed successfully";
    }

    public static void main(String[] args) throws SQLException {
        ICommodityBatchDAO commodityBatchDAO = new CommodityBatchDAO();
//        System.out.println(commodityBatchDAO.getCommodityBatch( 1 )); TODO fix the problem


        // Test createCommodityBatch
/*        Datalayer.DTO.CommodityBatchDTO commodityBatchDAO1 = new Datalayer.DTO.CommodityBatchDTO(3,3,5.4,"MD");
        commodityBatchDAO.createCommodityBatch( commodityBatchDAO1 );*/

        // Test commodityBatchList
        /*for (CommodityBatchDTO commodityBatchDTO : commodityBatchDAO.getCommodityBatchList()) {
            System.out.print( commodityBatchDTO.getCommodity_id() + " " );
            System.out.print( commodityBatchDTO.getCommodityBatch_id() + " " );
            System.out.print( commodityBatchDTO.getWeight() + " " );
            System.out.print( commodityBatchDTO.getSupplier() + " " );
            System.out.println();
        };

        // Test updateCommodityBatch
        CommodityBatchDTO commodityBatchDAO1 = new CommodityBatchDTO(3,3,9.4,"Update");
        commodityBatchDAO.updateCommodityBatch( commodityBatchDAO1 );
    }
}
*/