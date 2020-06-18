package Datalayer;

/***********************************************************************************
 *                                      DBUTil                                     *
 *---------------------------------------------------------------------------------*
 * connection: Connection                                                          *
 *---------------------------------------------------------------------------------*
 * getConnection():                                              Connection        *
 * getPrepareStatement(query: String):                           PreparedStatement *
 * executeSelectQuery(query: String, objects: Object[]):         ResultSet         *
 * executeCreateAndUpdate(query: String, objects: Object[])                        *
 * fillOutStatement(pstmt: PreparedStatement, objects: Object[])                   *
 * convertTOObject(parameter: Object...):                        Object[]          *
 * resultSetToObject(ResultSet resultSet, Class classObject)     Object            *
 * remainingParameter(objects: Object[], objectIndex: int, parameter: Object...)   *
 ***********************************************************************************/

import Datalayer.DTO.CommodityBatchDTO;

import javax.enterprise.context.RequestScoped;
import java.sql.*;

@RequestScoped
public class DBUtil {
    public static Connection getConnection() {
        Connection connection = null;
        try {
            Class.forName("org.mariadb.jdbc.Driver");
            connection = DriverManager.getConnection(PropertiesLoader.jdbcUrl,
                    PropertiesLoader.dbUserName, PropertiesLoader.dbPassword);
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return connection;
    }

    public static ResultSet executeSelectQuery(String query, Object[] parameter, Connection connection) throws SQLException {
        PreparedStatement pstmt = connection.prepareStatement(query);
        fillOutStatement(pstmt, parameter);
        return pstmt.executeQuery(); // todo
    }


    private static void fillOutStatement(PreparedStatement pstmt, Object[] objects)
            throws SQLException, NumberFormatException {
        int index = 1;
        if (objects != null) {

            for (Object object : objects) {

                if (object instanceof Integer) {
                    pstmt.setInt(index++, Integer.parseInt(object.toString()));
                } else if (object instanceof Double) {
                    pstmt.setDouble(index++, Double.parseDouble(object.toString()));
                } else if (object instanceof String) {
                    pstmt.setString(index++, object.toString());
                } else if(object instanceof Date) {
                    pstmt.setDate(index++ , Date.valueOf(((Date) object).toLocalDate()));
                }
            }
        }
    }
}


