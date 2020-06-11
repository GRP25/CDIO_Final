package REST.Services.Implementation;

import Datalayer.DAO.CommodityDAO;
import Datalayer.DAO.DALException;
import Datalayer.DTO.commodityDTO;
import Datalayer.Interfaces.ICommodityDAO;
import REST.Services.Interfaces.ICommodityService;
import java.util.List;

public class CommodityService implements ICommodityService {

    ICommodityDAO commodityDAO = new CommodityDAO();

    @Override
    public commodityDTO getCommodity(int commodity_id) throws DALException {
        return commodityDAO.getCommodity(commodity_id);
    }

    @Override
    public List<commodityDTO> getCommodityList() throws DALException{
        return commodityDAO.getCommodityList();
    }

    @Override
    public String createCommodity(commodityDTO commodity) throws DALException{
        commodityDAO.createCommodity(commodity);
        return "Insert query executed successfully";
    }

    @Override
    public String updateCommodity(commodityDTO commodity) throws DALException{
        commodityDAO.updateCommodity(commodity);
        return "Update query executed successfully";
    }



    public static void main(String[] args) throws DALException {
        ICommodityDAO commodityDAO = new CommodityDAO();


        Datalayer.DTO.commodityDTO commodityDAO1 = new Datalayer.DTO.commodityDTO(1, "bo");
        commodityDAO.createCommodity(commodityDAO1);

        for ( commodityDTO cmdtDTO : commodityDAO.getCommodityList()) {
            System.out.println(cmdtDTO.getCommodity_id() + " ");
            System.out.println(cmdtDTO.getCommodity_Name() + " ");
            System.out.println();
        }

        commodityDTO cmdtDAO1 = new commodityDTO(2, "bob");
        commodityDAO.updateCommodity(cmdtDAO1);

        System.out.println(commodityDAO.getCommodity(2));

    }
}