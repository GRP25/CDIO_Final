package Funclayer.implementation;

import Datalayer.DAO.CommodityBatchDAO;
import Datalayer.DTO.CommodityBatchDTO;
import Datalayer.Interfaces.ICommodityBatchDAO;
import Funclayer.exceptions.exceptions.IDException;
import Funclayer.exceptions.exceptions.ObjectException;
import Funclayer.interfaces.ICommodityBatchService;

import java.sql.SQLException;
import java.util.List;

import static Funclayer.exceptions.validation.CommodityBatchValidation.*;

public class CommodityBatchService implements ICommodityBatchService {

    ICommodityBatchDAO commodityBatchDAO = new CommodityBatchDAO();

    @Override
    public CommodityBatchDTO getCommodityBatch(int commodityBatch_id) throws SQLException {
        validateCommodityBatchID(commodityBatch_id);
        return commodityBatchDAO.getCommodityBatch( commodityBatch_id );
    }


    @Override
    public List<CommodityBatchDTO> getCommodityBatchList() throws SQLException {
        return commodityBatchDAO.getCommodityBatchList();
    }

    @Override
    public List<CommodityBatchDTO> getCommodityBatchList(int commodityBatch_id) throws SQLException {
        validateCommodityBatchID(commodityBatch_id);
        List<CommodityBatchDTO> commodityBatchDTOList = commodityBatchDAO.getCommodityBatchList( commodityBatch_id );

        if (commodityBatchDTOList.isEmpty())
            throw new ObjectException("No CommodityBatch exists with this number as an identification!");

        return commodityBatchDTOList;
    }

    @Override
    public String createCommodityBatch(CommodityBatchDTO batch) throws SQLException {
        commodityBatchValidation(batch);
        commodityBatchDAO.createCommodityBatch( batch );
        return "Insert query executed successfully";
    }

    @Override
    public String updateCommodityBatch(CommodityBatchDTO batch) throws SQLException {
        commodityBatchValidation(batch);
        commodityBatchDAO.updateCommodityBatch( batch );
        return "Update query executed successfully";
    }
}
