package REST.Services.Interfaces;

import Datalayer.DTO.CommodityBatchDTO;

import java.util.List;

public interface ICommodityBatchService {

        CommodityBatchDTO getCommodityBatch(int commodityBatch_id) ;

        List<CommodityBatchDTO> getCommodityBatchList() ;

        List<CommodityBatchDTO> getCommodityBatchList(int commodityBatch_id) ;

        String createCommodityBatch(CommodityBatchDTO batch) ;

        String updateCommodityBatch(CommodityBatchDTO batch) ;

}
