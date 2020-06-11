package Funclayer;

import Datalayer.DTO.UserDTO;

import java.util.List;

public interface IUserService
{
    UserDTO getUser(int userID);
    String updateUser(UserDTO user);
    String createUser(UserDTO user);
    String deleteUser(int userID);
    List<UserDTO> getUserList();

}
