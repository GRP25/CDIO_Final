package Funclayer;

import Datalayer.DAO.UserDAO;
import Datalayer.DTO.UserDTO;
import Datalayer.Interfaces.IUserDAO;

import javax.enterprise.context.RequestScoped;
import java.util.ArrayList;
import java.util.List;

@RequestScoped
public class UserService implements IUserService {


    IUserDAO userDao = new UserDAO();


    @Override
    public UserDTO getUser(int userID) {
         return userDao.getUser( userID );
    }

    @Override
    public void updateUser(UserDTO user) {
        userDao.updateUser( user );
    }

    @Override
    public void createUser(UserDTO user) {
        userDao.createUser( user );
    }

    @Override
    public void deleteUser(int userID) {
        //userDao.deactivateUser( userID );
    }

    @Override
    public List<UserDTO> getUserList() {
        return userDao.getUserList();
    }
}