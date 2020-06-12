package REST.Services.Interfaces;

import Datalayer.DTO.commodityDTO;

import java.sql.SQLException;
import java.util.List;

public interface ICommodityService {


    commodityDTO getCommodity(int commodity_id) throws SQLException;

    List<commodityDTO> getCommodityList() throws SQLException;

    String createCommodity(commodityDTO commodity) throws SQLException;

    String updateCommodity(commodityDTO commodity) throws SQLException;


}

