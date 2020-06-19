package Funclayer.interfaces;

import Datalayer.DTO.CommodityDTO;

import java.sql.SQLException;
import java.util.List;

public interface ICommodityService {


    CommodityDTO getCommodity(int commodity_id) throws SQLException;

    List<CommodityDTO> getCommodityList() throws SQLException;

    String createCommodity(CommodityDTO commodity) throws SQLException;

    String updateCommodity(CommodityDTO commodity) throws SQLException;


}

