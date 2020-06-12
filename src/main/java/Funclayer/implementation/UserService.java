package Funclayer.implementation;

import Datalayer.DAO.UserDAO;
import Datalayer.DTO.UserDTO;
import Datalayer.Interfaces.IUserDAO;
import Funclayer.interfaces.IUserService;

import javax.enterprise.context.RequestScoped;
import java.sql.SQLException;
import java.util.List;

@RequestScoped
public class UserService implements IUserService {


    IUserDAO userDao = new UserDAO();


    @Override
    public UserDTO getUser(int userID) throws SQLException {
         return userDao.getUser( userID );
    }

    @Override
    public void updateUser(UserDTO user) throws SQLException {
        userDao.updateUser( user );
    }

    @Override
    public void createUser(UserDTO user) throws SQLException {
        userDao.createUser( user );
    }

    @Override
    public void deleteUser(int userID) throws SQLException {
        userDao.deactivateUser( userID );
    }

    @Override
    public List<UserDTO> getUserList() throws SQLException {
        return userDao.getUserList();
    }
}