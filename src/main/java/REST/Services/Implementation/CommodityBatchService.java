package REST.Services.Implementation;

import Datalayer.DAO.CommodityBatchDAO;
import Datalayer.DAO.DALException;
import Datalayer.DTO.CommodityBatchDTO;
import Datalayer.Interfaces.ICommodityBatchDAO;
import REST.Services.Interfaces.ICommodityBatchService;

import java.util.List;

public class CommodityBatchService implements ICommodityBatchService {

    ICommodityBatchDAO commodityBatchDAO = new CommodityBatchDAO();

    @Override
    public CommodityBatchDTO getCommodityBatch(int commodityBatch_id) throws DALException {
        return commodityBatchDAO.getCommodityBatch( commodityBatch_id );
    }

    @Override
    public List<CommodityBatchDTO> getCommodityBatchList() throws DALException {
        return commodityBatchDAO.getCommodityBatchList();
    }

    @Override
    public List<CommodityBatchDTO> getCommodityBatchList(int commodityBatch_id) throws DALException {
        return commodityBatchDAO.getCommodityBatchList( commodityBatch_id );
    }

    @Override
    public String createCommodityBatch(CommodityBatchDTO batch) throws DALException {
        commodityBatchDAO.createCommodityBatch( batch );
        return "Insert query executed successfully";
    }

    @Override
    public String updateCommodityBatch(CommodityBatchDTO batch) throws DALException {
        commodityBatchDAO.updateCommodityBatch( batch );
        return "Update query executed successfully";
    }

    public static void main(String[] args) throws DALException {
        Datalayer.Interfaces.ICommodityBatchDAO commodityBatchDAO = new Datalayer.DAO.CommodityBatchDAO();
//        System.out.println(commodityBatchDAO.getCommodityBatch( 1 ));


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
        };*/

        // Test updateCommodityBatch
        CommodityBatchDTO commodityBatchDAO1 = new CommodityBatchDTO(3,3,9.4,"Update");
        commodityBatchDAO.updateCommodityBatch( commodityBatchDAO1 );
    }
}
