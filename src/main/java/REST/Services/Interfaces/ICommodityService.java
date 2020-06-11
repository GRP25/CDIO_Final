package REST.Services.Interfaces;

import Datalayer.DTO.commodityDTO;

import java.util.List;

public interface ICommodityService {


    commodityDTO getCommodity(int commodity_id);

    List<commodityDTO> getCommodityList();

    String createCommodity(commodityDTO commodity);

    String updateCommodity(commodityDTO commodity);


}

