package REST.Services.Interfaces;

import Datalayer.DAO.DALException;
import Datalayer.DTO.CommodityBatchDTO;

import java.util.List;

public interface ICommodityBatchDAO {

        CommodityBatchDTO getCommodityBatch(int commodityBatch_id) throws DALException;

        List<CommodityBatchDTO> getCommodityBatchList() throws DALException;

        List<CommodityBatchDTO> getCommodityBatchList(int commodityBatch_id) throws DALException;

        void createCommodityBatch(CommodityBatchDTO batch) throws DALException;

        void updateCommodityBatch(CommodityBatchDTO batch) throws DALException;

}
