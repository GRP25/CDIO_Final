package Datalayer.DAO;

import DB.DBUtil;
import Datalayer.Interfaces.IUserDAO;
import Datalayer.DTO.UserDTO;

import javax.enterprise.context.RequestScoped;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@RequestScoped
public class UserDAO implements IUserDAO {

    @Override
    public void createUser(UserDTO user) {
        String query = "INSERT INTO Users (firstname, surname, initials, cpr) values (?,?,?,?);";
        Connection connection = DBUtil.getConnection();

        Object[] parameter = user.convertToObject();

        try {
            DBUtil.executeSelectQuery(query, parameter, connection);

            ResultSet rs = DBUtil.executeSelectQuery("SELECT LAST_INSERT_ID()", null, connection);

            String ID = "";
            while (rs.next()) {
                ID = rs.getString("LAST_INSERT_ID()");
            }

            // assigning role to user
            query = "INSERT INTO has_roles (user_id, roles_title) VALUES ";
            for (String role : user.getRoles()) {
                query += "('" + ID + "', '" + role + "'),";
            }
            query = query.substring(0, query.length() - 1);

            DBUtil.executeSelectQuery(query, null, connection);
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<UserDTO> getUserList() {
        String query = "SELECT * FROM user";
        Connection connection = DBUtil.getConnection();

        ResultSet rs = DBUtil.executeSelectQuery(query, null, connection);
        List<UserDTO> users = new ArrayList<>();
        UserDTO user = new UserDTO();
        try {
            while (rs.next()) {
                user.interpretResultSet(rs);
                users.add(user);
            }

            for (UserDTO userTemp : users) {
                userTemp.setRoles(get_user_roles(userTemp.getUserID(), connection));
            }

            // closing connections
            connection.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return users;
    }

    @Override
    public UserDTO getUser(int ID) {
        UserDTO user = new UserDTO();
        String query = "SELECT * FROM user WHERE userId = ?;";

        try {
            Connection connection = DBUtil.getConnection();
            Object[] parameter = new Object[1];
            ResultSet rs = DBUtil.executeSelectQuery(query, parameter, connection);
            if (rs.next()) {

                user.interpretResultSet(rs);
                user.setRoles(get_user_roles(ID, connection));
            }
            connection.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return user;
    }

    @Override
    public void updateUser(UserDTO user) {
        String query = "UPDATE user SET firstname = ? , " + "surname = ? ," + "initials = ? , " + "cpr = ? , "
                + "WHERE userId = ?";

        try {
            Connection connection = DBUtil.getConnection();

            Object[] parameter = user.convertToObject();
            ResultSet rs = DBUtil.executeSelectQuery(query, parameter, connection);
            user.interpretResultSet(rs);

            // assignong roles to user
            query = "INSERT INTO has_roles (user_id, roles_title) VALUES ";
            for (String role : user.getRoles()) {
                query += "('" + user.getUserID() + "', '" + role + "'),";
            }
            query = query.substring(0, query.length() - 1);

            DBUtil.executeSelectQuery(query, null, connection);
            connection.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void deactivateUser(int id) {
        String query = "UPDATE Users set status = ? WHERE userId=?";
        Connection connection = DBUtil.getConnection();
        Object[] parameter = { 0, id };
        try {
            DBUtil.executeSelectQuery(query, parameter, connection);
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /*
     * @Override public boolean exists(int id) { String sql =
     * "SELECT from user WHERE user_id = ?"; try ( Connection conn = connect();
     * PreparedStatement pstmt = conn.prepareStatement(sql) ) { pstmt.setInt(1, id);
     * pstmt.executeUpdate(); } catch (SQLException e) { return false; } return
     * true; }
     * 
     * @Override public boolean exists(String cpr) { String sql =
     * "SELECT from user WHERE user_cpr = ?"; try ( Connection conn = connect();
     * PreparedStatement pstmt = conn.prepareStatement(sql) ) { pstmt.setString(1,
     * cpr); pstmt.executeUpdate(); } catch (SQLException e) { return false; }
     * return true; }
     */

    private ArrayList<String> get_user_roles(int id, Connection connection) throws SQLException {
        String query = "SELECT roleName FROM UserRole WHERE userId=" + id;
        ResultSet rs = DBUtil.executeSelectQuery(query, null, connection);
        ArrayList<String> roleList = new ArrayList<>();

        while (rs.next()) {
            roleList.add(rs.getString("roleName"));
        }

        return roleList;
    }

}
