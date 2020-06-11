package REST.Services.Implementation;

import Datalayer.DAO.CommodityBatchDAO;
import Datalayer.DTO.CommodityBatchDTO;
import Datalayer.Interfaces.ICommodityBatchDAO;
import REST.Services.Interfaces.ICommodityBatchService;

import java.util.List;

public class CommodityBatchService implements ICommodityBatchService {

    ICommodityBatchDAO commodityBatchDAO = new CommodityBatchDAO();

    @Override
    public CommodityBatchDTO getCommodityBatch(int commodityBatch_id) {
        return commodityBatchDAO.getCommodityBatch( commodityBatch_id );
    }

    @Override
    public List<CommodityBatchDTO> getCommodityBatchList() {
        return commodityBatchDAO.getCommodityBatchList();
    }

    @Override
    public List<CommodityBatchDTO> getCommodityBatchList(int commodityBatch_id) {
        return commodityBatchDAO.getCommodityBatchList( commodityBatch_id );
    }

    @Override
    public String createCommodityBatch(CommodityBatchDTO batch) {
        commodityBatchDAO.createCommodityBatch( batch );
        return "Insert query executed successfully";
    }

    @Override
    public String updateCommodityBatch(CommodityBatchDTO batch) {
        commodityBatchDAO.updateCommodityBatch( batch );
        return "Update query executed successfully";
    }
}
