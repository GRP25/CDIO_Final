package Datalayer.DAO.Interfaces;

import java.sql.SQLException;
import java.util.List;

import Datalayer.DTO.IDTO.IDTO;

public interface IValidation {
	public boolean exists(int id) throws SQLException;
}