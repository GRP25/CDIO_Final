import DB.DBUtil;
package Datalayer.DAO;

import Datalayer.Interfaces.IUserDAO;
import Datalayer.DTO.UserDTO;

import javax.enterprise.context.RequestScoped;
import java.sql.*;
import java.util.ArrayList;

import static data.sql.Ctrl.*;

@RequestScoped
public class UserDAO implements IUserDAO {

    @Override
    public void createUser(UserDTO user) {
        String sql = "INSERT INTO Users (firstname, surname, initials, cpr) values (?,?,?,?);";

        try {
            Connection conn = connect();
            PreparedStatement pstmt = conn.prepareStatement(sql);

            pstmt.setString(1, user.getFirstName());
            pstmt.setString(2,user.getSurname());
            pstmt.setString(3, user.getInitials());
            pstmt.setString(4, user.getCpr());
            pstmt.executeUpdate();

            // getting id from last inserted user
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT LAST_INSERT_ID();");

            String ID = "";
            while (rs.next()) {
                ID = rs.getString("LAST_INSERT_ID()");
            }
            
            // assigning roles to user
            sql = "INSERT INTO has_roles (user_id, roles_title) VALUES ";
            for (String role :  user.getRoles()) {
                sql += "('" + ID + "', '" + role + "'),";
            }
            sql = sql.substring(0,sql.length() - 1);
            stmt.executeQuery(sql);

        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    @Override
    public ArrayList<UserDTO> getUserList() {
        String sql = "SELECT * FROM user";
        ArrayList<UserDTO> users = new ArrayList<>();
        try {
            Connection conn = connect();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);

            // loop through the result set
            UserDTO user;
            int     id;
            while (rs.next()) {
                user = new UserDTO();
                id = rs.getInt("userId");
                user.setUserID(id);
                user.setFirstName(rs.getString("firstname"));
                user.setSurname(rs.getString("surname"));
                user.setInitials(rs.getString("initials"));
                user.setCpr(rs.getString("cpr"));
            //    user.setRoles(stringToGroup(rs.getString("user_groups")));
                users.add(user);
            }

            for (UserDTO userTemp : users) {
                stmt = conn.createStatement();
                userTemp.setRoles(get_user_roles(userTemp.getUserID(), stmt));
            }

            // closing connections
            conn.close();
            stmt.close();
            rs.close();
        } 
        catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return users;
    }

    @Override
    public UserDTO getUser(int ID) {
        UserDTO user = new UserDTO();
        String sql = "SELECT * FROM user WHERE userId = ?;";

        try
         {
            Connection conn = connect();
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, ID);
            ResultSet rs = pstmt.executeQuery();
             if(rs.next()) {
                 user.setUserID(ID);
                 user.setFirstName(rs.getString("firstname"));
                 user.setSurname(rs.getString("surname"));
                 user.setInitials(rs.getString("initials"));
                 user.setCpr(rs.getString("cpr"));
                 user.setRoles(get_user_roles(ID, pstmt));
             }
            rs.close();
            pstmt.close();
            conn.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
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

        try {
            Connection conn = connect();
            PreparedStatement pstmt = conn.prepareStatement(sql);
            // set the corresponding param
            pstmt.setString(1, user.getFirstName());
            pstmt.setString(2,user.getSurname());
            pstmt.setString(3, user.getInitials());
            pstmt.setString(4, user.getCpr());
            pstmt.setInt(5, user.getUserID());
            // update
            pstmt.executeUpdate();

            // assigning roles to user
            sql = "DELETE FROM has_roles WHERE userId = "+user.getUserID();
            pstmt.executeQuery(sql);
            sql = "INSERT INTO has_roles (userId, roles_title) VALUES ";
            for (String role :  user.getRoles()) {
                sql += "('" + user.getUserID() + "', '" + role + "'),";
            }
            sql = sql.substring(0,sql.length() - 1);
            pstmt.executeQuery(sql);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void deactivateUser(int id) {
        String sql = "UPDATE user set status = ?";
        try (
                Connection conn = connect();
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
