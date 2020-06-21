package Funclayer.implementation;

import Datalayer.DAO.UserDAO;
import Datalayer.DTO.UserDTO;
import Datalayer.Interfaces.IUserDAO;
import Funclayer.exceptions.exceptions.DataLayerException;
import Funclayer.interfaces.IUserService;

import javax.enterprise.context.RequestScoped;
import java.sql.SQLException;
import java.util.List;

import static Funclayer.exceptions.validation.UserValidation.validateUserForCreate;
import static Funclayer.exceptions.validation.UserValidation.validateUserForUpdate;

@RequestScoped
public class UserService implements IUserService {
    IUserDAO userDao = new UserDAO();

    @Override
    public UserDTO getUser(int userID) throws SQLException {
        UserDTO userDTO = userDao.getUser(userID);
        if (userDTO.getUserID() == 0)
            throw new DataLayerException("No user exists with this number as an identification!");
        return userDTO;
    }

    @Override
    public void updateUser(UserDTO user) throws SQLException {
        validateUserForUpdate(user);
        userDao.updateUser(user);
    }

    @Override
    public void createUser(UserDTO user) throws SQLException {
        validateUserForCreate(user);
        userDao.createUser(user);
    }

    @Override
    public void deleteUser(int userID) throws SQLException {
        if (!userDao.deactivateUser(userID))
            throw new DataLayerException("No user exists with this number as an identification!");
    }

    @Override
    public List<UserDTO> getUserList() throws SQLException {
        return userDao.getUserList();
    }
}