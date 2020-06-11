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
    public String updateUser(UserDTO user) {
        userDao.updateUser( user );
        return "Update query executed successfully";
    }

    @Override
    public String createUser(UserDTO user) {
        userDao.createUser( user );
        return "Insert query executed successfully";
    }

    @Override
    public String deleteUser(int userID) {
        //userDao.deactivateUser( userID );
        return "Update query executed successfully";
    }

    @Override
    public List<UserDTO> getUserList() {
        return userDao.getUserList();
    }
}