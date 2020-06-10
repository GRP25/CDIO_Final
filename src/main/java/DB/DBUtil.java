package DB;

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
 ***********************************************************************************/

import Datalayer.DTO.CommodityBatchDTO;
import org.apache.ibatis.jdbc.ScriptRunner;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.sql.*;

public class DBUtil {

    static Connection connection;

    static {

        try {

            DriverManager.registerDriver( new com.mysql.cj.jdbc.Driver() );

        } catch (SQLException e) {

            e.printStackTrace();

        }
    }

    /** Registering the Driver */
    public static void main(String[] args) {
        InputStream inputStream = DBUtil.class.getClassLoader().
                        getResourceAsStream( "sqlQueries.sql" );
        Connection connection = getConnection();

        // Test
        System.out.println("Connection established");

        // Initialize the script runner
        ScriptRunner scriptRunner = new ScriptRunner( connection );

        // Creating a reader object
        Reader reader = new InputStreamReader( inputStream );

        // Running the script
        scriptRunner.runScript( reader );

    }



    private static Connection getConnection() {

        if (connection == null)
            try{

                connection = DriverManager.getConnection( PropertiesLoader.jdbcUrl,
                            PropertiesLoader.dbUserName, PropertiesLoader.dbPassword );
                return connection;

            } catch (SQLException e) {

                e.printStackTrace();
                return connection;

            }

        return connection;
    }


    public static ResultSet executeSelectQuery(String query, Object[] objects) {
        try {
            PreparedStatement pstmt = getPrepareStatement(query);

            fillOutStatement( pstmt, objects);

            return pstmt.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }

    }


    public static void executeCreateAndUpdate(String query, Object[] objects)
                                                           throws SQLException {
        PreparedStatement preparedStatement = getPrepareStatement( query );
        fillOutStatement( preparedStatement, objects );
        try {
            preparedStatement.executeUpdate(); // TODO
        }catch (SQLException e) {
            e.printStackTrace();
        }

    }

    private static PreparedStatement getPrepareStatement(String query)
                                                     throws SQLException {
        return  getConnection().prepareStatement( query );
    }

    private static void fillOutStatement(PreparedStatement pstmt, Object[] objects)
                                        throws SQLException, NumberFormatException {
        int index = 1;
        if (objects != null) {

            for (Object object : objects) {

                if (object instanceof Integer) {
                    pstmt.setInt( index++, Integer.parseInt( object.toString() ) );
                }else if(object instanceof Double) {
                    pstmt.setDouble( index++, Double.parseDouble( object.toString() ) );
                }else if (object instanceof String) {
                    pstmt.setString( index++, object.toString() );
                }

            }

        }

    }


    public static Object[] convertTOObject(Object... parameter){
        Object[] object;
        if (parameter[0] instanceof CommodityBatchDTO){

            CommodityBatchDTO comDto =  (CommodityBatchDTO) parameter[0];

            object = new Object[4]; // TODO

            object[0] = comDto.getCommodity_id();
            object[1] = comDto.getCommodityBatch_id();
            object[2] = comDto.getWeight();
            object[3] = comDto.getSupplier();

            return object;
        }


        // If the parameter is integer, double , String or so on.
        int index = 0;
        object = new Object[parameter.length];
        for (Object o : object) {
            object[index++] = o;
        }

        return object;
    }

    public static Object resultSetToObject(ResultSet resultSet, Class classObject)
                                                                throws SQLException{

        if (classObject.getSimpleName().equalsIgnoreCase( "CommodityBatch" )) {

            CommodityBatchDTO comDto = new CommodityBatchDTO();

            comDto.setCommodity_id( resultSet.getInt( 1 ) );
            comDto.setCommodityBatch_id( resultSet.getInt( 2 ) );
            comDto.setWeight( resultSet.getInt( 3 ) );
            comDto.setSupplier( resultSet.getString( 4 ) );

            return comDto;

        }

        return null;
    }






}


