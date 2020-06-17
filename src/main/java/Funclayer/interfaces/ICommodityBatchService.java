package Funclayer.interfaces;

import Datalayer.DTO.CommodityBatchDTO;

import java.sql.SQLException;
import java.util.List;

public interface ICommodityBatchService {

        CommodityBatchDTO getCommodityBatch(int commodityBatch_id) throws SQLException;

        List<CommodityBatchDTO> getCommodityBatchList() throws SQLException;

        List<CommodityBatchDTO> getCommodityBatchList(int commodityBatch_id) throws SQLException;

        String createCommodityBatch(CommodityBatchDTO batch) throws SQLException;

        String updateCommodityBatch(CommodityBatchDTO batch) throws SQLException;

}
