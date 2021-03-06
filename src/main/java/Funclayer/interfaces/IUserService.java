package Funclayer.interfaces;

import Datalayer.DTO.UserDTO;

import java.sql.SQLException;
import java.util.List;

public interface IUserService {
    UserDTO getUser(int userID) throws SQLException;

    void updateUser(UserDTO user) throws SQLException;

    void createUser(UserDTO user) throws SQLException;

    void deleteUser(int userID) throws SQLException;
    void activateUser(int userID) throws SQLException;

    List<UserDTO> getUserList() throws SQLException;
}
