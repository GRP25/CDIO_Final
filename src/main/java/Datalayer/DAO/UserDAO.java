package Datalayer.DAO;

import DB.DBUtil;
import Datalayer.Interfaces.IUserDAO;
import Datalayer.DTO.UserDTO;

import javax.enterprise.context.RequestScoped;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import Datalayer.DatabaseHandler;

@RequestScoped
public class UserDAO implements IUserDAO {

    @Override
    public void createUser(UserDTO user) {
        String sql = "INSERT INTO Users (firstname, surname, initials, cpr) values (?,?,?,?);";
        Object[] parameter = DBUtil.convertTOObject(user);

        try {
            DBUtil.executeCreateAndUpdate(sql,parameter);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<UserDTO> getUserList() {
        String sql = "SELECT * FROM user";

        ResultSet resultset = DBUtil.executeSelectQuery(sql,null);
        List<UserDTO> users = new ArrayList<>();

        try {
            UserDTO userDTO;
            while(resultset.next()){
                userDTO = (UserDTO) DBUtil.resultSetToObject(resultset,UserDTO.class);
                users.add(userDTO);
            }
        } 
        catch (SQLException e) {
            e.printStackTrace();
            return null;
        }

        return users;
    }

    @Override
    public UserDTO getUser(int ID) {
        String sql = "SELECT * FROM user WHERE userId = ?;";

        Object[] parameter = DBUtil.convertTOObject(ID);
        ResultSet resultSet = DBUtil.executeSelectQuery(sql,parameter);
        UserDTO user;

        try {
            resultSet.first();
            user = (UserDTO) DBUtil.resultSetToObject(resultSet, UserDTO.class);

        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
        return user;
    }

    @Override
    public void updateUser(UserDTO user) {
        String sql = "UPDATE user SET firstname = ? , "
                + "surname = ? ,"
                + "initials = ? , "
                + "cpr = ? , "
                + "WHERE userId = ?";
        Object[] parameter = DBUtil.convertTOObject(user);


        try {
            DBUtil.executeCreateAndUpdate(sql,parameter);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deactivateUser(int id) {
        String sql = "UPDATE user set status = ?";
        try (
                Connection conn = DatabaseHandler.connect();
                PreparedStatement pstmt = conn.prepareStatement(sql)
        ) {
            pstmt.setInt(1, id);
            pstmt.executeUpdate();
            System.out.println("User succsessfully deleted");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    /*@Override
    public boolean exists(int id) {
        String sql = "SELECT from user WHERE user_id = ?";
        try (
                Connection conn = connect();
                PreparedStatement pstmt = conn.prepareStatement(sql)
        ) {
            pstmt.setInt(1, id);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            return false;
        }
        return true;
    }

    @Override
    public boolean exists(String cpr) {
        String sql = "SELECT from user WHERE user_cpr = ?";
        try (
                Connection conn = connect();
                PreparedStatement pstmt = conn.prepareStatement(sql)
        ) {
            pstmt.setString(1, cpr);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            return false;
        }
        return true;
    }*/

    private ArrayList<String> get_user_roles(int id, Statement stmt) throws SQLException{
        String sql = "SELECT roleName FROM UserRole WHERE userId=" + id;
        ResultSet rs = stmt.executeQuery(sql);
        ArrayList<String> roleList = new ArrayList<>();

        while (rs.next()) {
            roleList.add(rs.getString("roleName"));
        }

        return roleList;
    }

}
