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

    public static ResultSet executeSelectQuery(String query, Object[] parameter, Connection connection) {
        try {
            PreparedStatement pstmt = connection.prepareStatement(query);

            fillOutStatement(pstmt, parameter);

            return pstmt.executeQuery(); // todo
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }

    }


    public static void executeCreateAndUpdate(String query, Object[] objects, Connection connection)
            throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        fillOutStatement(preparedStatement, objects);

        preparedStatement.executeUpdate();

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
                }

            }

        }

    }


    public static Object[] convertTOObject(Object... parameter) {
        Object[] objects;
        if (parameter[0] instanceof CommodityBatchDTO) {

            CommodityBatchDTO comDto = (CommodityBatchDTO) parameter[0];

            // parameter.length -1 because when update method is invoked from CommodityBatchDAO
            // It will have two parameter.length = 2(Object, Object.id), and the objects[5] will
            // have the Object.id and assign the Object.id to WHERE in sql query, but create method
            // Is invoked it will have just one parameter (Object), and INSERT query doesn't require WHERE
            objects = new Object[4 + parameter.length - 1];

            objects[0] = comDto.getCommodity_id();
            objects[1] = comDto.getCommodityBatch_id();
            objects[2] = comDto.getWeight();
            objects[3] = comDto.getSupplier();

            // To assign Object.id to Objects[lastIndex]
            remainingParameter(objects, 4, parameter);

            return objects;
        }


        // If the parameter is integer, double , String or so on.
        int index = 0;
        objects = new Object[parameter.length];
        for (Object o : parameter) {
            objects[index++] = o;
        }

        return objects;
    }

    /**
     * To assign values to WHERE's sql query
     */
    private static void remainingParameter(Object[] objects, int objectIndex, Object... parameter) {
        for (int parameterIndex = 1; parameterIndex < parameter.length; objectIndex++, parameterIndex++) {
            objects[objectIndex] = parameter[parameterIndex];
        }
    }


}


