package REST.Services.Interfaces;

import Datalayer.DAO.DALException;
import Datalayer.DTO.commodityDTO;

import java.util.List;

public interface ICommodityService {


    commodityDTO getCommodity(int commodity_id) throws DALException;

    List<commodityDTO> getCommodityList() throws DALException;

    String createCommodity(commodityDTO commodity) throws DALException;

    String updateCommodity(commodityDTO commodity) throws DALException;


}

