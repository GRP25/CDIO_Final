package Funclayer;

import Datalayer.DTO.UserDTO;

import java.util.ArrayList;
import java.util.List;

public interface IUserService
{
    UserDTO getUser(int userID);
    void updateUser(UserDTO user);
    void createUser(UserDTO user);
    void deleteUser(int userID);
    List<UserDTO> getUserList();

}
