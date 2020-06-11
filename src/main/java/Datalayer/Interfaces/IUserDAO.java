package Datalayer.Interfaces;

import Datalayer.DTO.UserDTO;

import java.util.List;

public interface IUserDAO{

    UserDTO getUser(int userID);

    List<UserDTO> getUserList();

    void createUser(UserDTO user);

    void updateUser(UserDTO user);

    void deactivateUser(int userID);

    boolean exists(String cpr);

    boolean exists(int id);
}