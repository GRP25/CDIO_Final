package DB;

import org.apache.ibatis.jdbc.ScriptRunner;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

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
        InputStream inputStream = DBUtil.class.getClassLoader().getResourceAsStream( "sqlQueries.sql" );
        Connection connection = getConnection();

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

                connection = DriverManager.getConnection( PropertiesLoader.jdbcUrl, PropertiesLoader.dbUserName, PropertiesLoader.dbPassword );
                return connection;

            } catch (SQLException e) {

                e.printStackTrace();
                return connection;

            }

        return connection;

    }
}
