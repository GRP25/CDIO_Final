package REST.Services.Interfaces;

import Datalayer.DAO.DALException;
import Datalayer.DTO.CommodityBatchDTO;

import java.util.List;

public interface ICommodityBatchService {

        CommodityBatchDTO getCommodityBatch(int commodityBatch_id) throws DALException;

        List<CommodityBatchDTO> getCommodityBatchList() throws DALException;

        List<CommodityBatchDTO> getCommodityBatchList(int commodityBatch_id) throws DALException;

        String createCommodityBatch(CommodityBatchDTO batch) throws DALException;

        String updateCommodityBatch(CommodityBatchDTO batch) throws DALException;

}
