package Datalayer.Interfaces;

import Datalayer.DTO.UserDTO;

import java.util.ArrayList;

public interface IUserDAO{

    UserDTO getUser(int userID);

    ArrayList<UserDTO> getUserList();

    void createUser(UserDTO user);

    void updateUser(UserDTO user);

    void deactivateUser(int userID);
}