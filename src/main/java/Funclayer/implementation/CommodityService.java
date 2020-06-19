
package Funclayer.implementation;

import Datalayer.DAO.CommodityDAO;
import Datalayer.DTO.CommodityDTO;
import Datalayer.Interfaces.ICommodityDAO;
import Funclayer.exceptions.exceptions.ObjectException;
import Funclayer.interfaces.ICommodityService;

import java.sql.SQLException;
import java.util.List;

import static Funclayer.exceptions.validation.CommodityValidation.commodityValidation;

public class CommodityService implements ICommodityService {

    ICommodityDAO commodityDAO = new CommodityDAO();

    @Override
    public CommodityDTO getCommodity(int commodity_id) throws SQLException {

        CommodityDTO commodityDTO = commodityDAO.getCommodity(commodity_id);

        if (commodityDTO.getCommodity_id() == 0)
            throw new ObjectException("No Commodity exists with this number as an identification!");

        return commodityDTO;

    }

    @Override
    public List<CommodityDTO> getCommodityList() throws SQLException {
        return commodityDAO.getCommodityList();
    }

    @Override
    public String createCommodity(CommodityDTO commodity) throws SQLException {
        commodityValidation(commodity);
        commodityDAO.createCommodity(commodity);
        return "Insert query executed successfully";
    }

    @Override
    public String updateCommodity(CommodityDTO commodity) throws SQLException {
        commodityValidation(commodity);
        commodityDAO.updateCommodity(commodity);
        return "Update query executed successfully";
    }

}