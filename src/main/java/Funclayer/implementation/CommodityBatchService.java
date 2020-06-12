package Funclayer.implementation;

import Datalayer.DAO.CommodityBatchDAO;
import Datalayer.DTO.CommodityBatchDTO;
import Datalayer.Interfaces.ICommodityBatchDAO;
import Funclayer.interfaces.ICommodityBatchService;

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
}
