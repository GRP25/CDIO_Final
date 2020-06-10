package data.sql;

import javax.enterprise.context.RequestScoped;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;

@RequestScoped
public class Ctrl {

    public static Connection connect() {
        String user, pass, url;
        //TODO make a configuration file
        user = "cdio";
        pass = "HmDjHb0b4123";
        url = "jdbc:mariadb://mama.sh:4123/final";
        Connection conn = null;
        try {
            Class.forName("org.mariadb.jdbc.Driver");
            conn = DriverManager.getConnection(url, user, pass);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return conn;
    }
}
