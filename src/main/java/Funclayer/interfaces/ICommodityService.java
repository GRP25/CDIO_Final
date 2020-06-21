package Funclayer.interfaces;

import Datalayer.DTO.CommodityDTO;

import java.sql.SQLException;
import java.util.List;

public interface ICommodityService {
    CommodityDTO getCommodity(int commodity_id) throws SQLException;

    List<CommodityDTO> getCommodityList() throws SQLException;

    void createCommodity(CommodityDTO commodity) throws SQLException;

    void updateCommodity(CommodityDTO commodity) throws SQLException;
}

