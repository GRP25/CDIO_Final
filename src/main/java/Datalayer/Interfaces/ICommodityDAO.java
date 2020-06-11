package Datalayer.Interfaces;
import java.util.List;

import Datalayer.DAO.DALException;
import Datalayer.DTO.commodityDTO;


public interface ICommodityDAO {

	commodityDTO getCommodity(int commodity_id) throws DALException;

	List<commodityDTO> getCommodityList() throws DALException;

	void createCommodity(commodityDTO commodity) throws DALException;

	void updateCommodity(commodityDTO commodity) throws DALException;

}