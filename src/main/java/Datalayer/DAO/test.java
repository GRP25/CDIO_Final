package Datalayer.DAO;

import Datalayer.DTO.UserDTO;

import java.sql.SQLException;

public class test {
    public static void main(String[] args) {
        UserDAO u = new UserDAO();
        try {
            UserDTO usr = u.getUser(1);
            System.out.println(usr.getFirstName());
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
