package REST.Services.Implementation;

import Datalayer.DAO.DALException;
import Datalayer.DTO.CommodityBatchDTO;
import REST.Services.Interfaces.ICommodityBatchDAO;

import java.util.List;

public class CommodityBatchDAO implements ICommodityBatchDAO {

    Datalayer.Interfaces.ICommodityBatchDAO commodityBatchDAO = new Datalayer.DAO.CommodityBatchDAO();

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
    public void createCommodityBatch(CommodityBatchDTO batch) throws DALException {
        commodityBatchDAO.createCommodityBatch( batch );
    }

    @Override
    public void updateCommodityBatch(CommodityBatchDTO batch) throws DALException {
        commodityBatchDAO.updateCommodityBatch( batch );
    }

    public static void main(String[] args) throws DALException {
        Datalayer.Interfaces.ICommodityBatchDAO commodityBatchDAO = new Datalayer.DAO.CommodityBatchDAO();
//        System.out.println(commodityBatchDAO.getCommodityBatch( 1 ));
        Datalayer.DTO.CommodityBatchDTO commodityBatchDAO1 = new Datalayer.DTO.CommodityBatchDTO(3,3,5.4,"MD");
        commodityBatchDAO.createCommodityBatch( commodityBatchDAO1 );
    }
}
