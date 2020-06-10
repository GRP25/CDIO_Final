package DBUtil;

import java.io.IOException;
import java.util.Properties;
import java.io.InputStream;

public class PropertiesLoader {

    static String jdbcUrl = "db.jdbc.url";
    static String dbUserName = "db.userName";
    static String dbPassword = "db.password";

    /** Instead of: public static void main(String[] args) */
    static {

        Properties properties = new Properties();

        try (InputStream inputStream = Properties.class.getClassLoader().getResourceAsStream( "app.properties" )) {

            properties.load( inputStream );

        } catch (IOException e) {

            e.printStackTrace();

        }

        jdbcUrl = properties.getProperty( jdbcUrl );
        dbUserName = properties.getProperty( dbUserName );
        dbPassword = properties.getProperty( dbPassword );
    }
}
