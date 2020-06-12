package Datalayer.DAO;

import Datalayer.DTO.UserDTO;

import java.sql.SQLException;
import java.util.ArrayList;

public class testDAO {
    public static void main(String[] args) {
        UserDAO userdao = new UserDAO();
        try {
            userdao.deactivateUser(1);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
