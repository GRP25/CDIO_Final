package Datalayer.Interfaces;

import Datalayer.DTO.UserDTO;

import java.sql.SQLException;
import java.util.List;

public interface IUserDAO {

	UserDTO getUser(int userID) throws SQLException;

	List<UserDTO> getUserList() throws SQLException;

	void createUser(UserDTO user) throws SQLException, SQLException;

	void updateUser(UserDTO user) throws SQLException;

	boolean changeUserStatus(int status, int userID) throws SQLException;

	boolean exists(String cpr) throws SQLException;

	boolean exists(int id) throws SQLException;
}