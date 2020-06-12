package Datalayer.DAO;

import Datalayer.DBUtil;
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
    public void createUser(UserDTO user) throws SQLException{
        String query = "INSERT INTO Users (firstname, surname, cpr, initials, status) values (?,?,?,?,?);";
        Connection connection = DBUtil.getConnection();
        Object[] parameter = user.convertToObject();
        DBUtil.executeSelectQuery(query, parameter, connection);
        ResultSet rs = DBUtil.executeSelectQuery("SELECT LAST_INSERT_ID()", null, connection);
        String ID = "";
        while (rs.next()) {
            ID = rs.getString("LAST_INSERT_ID()");
        }
        // assigning role to user
        query = "INSERT INTO UserRole (userId, roleName) VALUES ";
        for (String role : user.getRoles()) {
            query += "('" + ID + "', '" + role + "'),";
        }
        query = query.substring(0, query.length() - 1);
        DBUtil.executeSelectQuery(query, null, connection);
        connection.close();
    }

    @Override
    public List<UserDTO> getUserList() throws SQLException {
        String query = "SELECT * FROM Users";
        Connection connection = DBUtil.getConnection();
        ResultSet rs = DBUtil.executeSelectQuery(query, null, connection);
        List<UserDTO> users = new ArrayList<>();
        UserDTO user;
        while (rs.next()) {
            user = new UserDTO();
            user.interpretResultSet(rs);
            users.add(user);
        }
        for (UserDTO userTemp : users) {
            userTemp.setRoles(get_user_roles(userTemp.getUserID(), connection));
        }
        // closing connections
        connection.close();
        return users;
    }

    @Override
    public UserDTO getUser(int ID) throws SQLException {
        UserDTO user = new UserDTO();
        String query = "SELECT * FROM Users WHERE userId = ?;";
        Connection connection = DBUtil.getConnection();
        Object[] parameter = DBUtil.convertTOObject(ID);
        ResultSet rs = DBUtil.executeSelectQuery(query,parameter,connection);
        if (rs.next()) {
            user.interpretResultSet(rs);
            user.setRoles(get_user_roles(ID, connection));
        }
        connection.close();
        return user;
    }

    @Override
    public void updateUser(UserDTO user) throws SQLException {
        String query = "UPDATE Users SET firstname = ? , surname = ? , cpr = ?, initials = ? , status = ? WHERE userId = " + user.getUserID();
        Connection connection = DBUtil.getConnection();
        Object[] parameter = user.convertToObject();
        ResultSet rs = DBUtil.executeSelectQuery(query, parameter, connection);
        if (rs.next()) {
            user.interpretResultSet(rs);
        }
    }

    @Override
    public void deactivateUser(int id) throws SQLException {
        String query = "UPDATE Users set status = ? WHERE userId = ?;";
        Connection connection = DBUtil.getConnection();
        Object[] parameter = { 0, id };
        DBUtil.executeSelectQuery(query, parameter, connection);
        connection.close();
    }

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
