package Datalayer.Interfaces;

import Datalayer.DTO.UserDTO;

import java.sql.SQLException;
import java.util.List;

public interface IUserDAO {

    UserDTO getUser(int userID) throws SQLException;

    List<UserDTO> getUserList();

    void createUser(UserDTO user);

    void updateUser(UserDTO user) throws SQLException;

    void deactivateUser(int userID) throws SQLException;
}