package Funclayer;

import Datalayer.DTO.UserDTO;

import java.util.ArrayList;

public interface IUserService
{
    UserDTO getUser(int userID);
    void updateUser(UserDTO user);
    void createUser(UserDTO user);
    void deleteUser(int userID);
    ArrayList<UserDTO> getUserList();

}
