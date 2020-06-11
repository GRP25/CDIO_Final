package REST.Services.Interfaces;

import Datalayer.DTO.UserDTO;
import Funclayer.exceptions.UserException;

import java.util.List;

public interface IUserRecource {
    UserDTO getUser(int userID);

    void updateUser(UserDTO user) throws UserException;

    void createUser(UserDTO user) throws UserException;

    void deleteUser(int userID);

    List<UserDTO> getUserList();
}
