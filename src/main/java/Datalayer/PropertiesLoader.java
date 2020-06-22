package Datalayer;
public class PropertiesLoader {
    static String jdbcUrl = "jdbc:mariadb://mama.sh:4123/pharmacy";
    static String dbUserName = "cdio";
    static String dbPassword = "HmDjHb0b4123";

    public static boolean updateDatabaseURL(){
        if (jdbcUrl.equals("jdbc:mariadb://mama.sh:4123/pharmacy")) {
            PropertiesLoader.jdbcUrl = "jdbc:mariadb://pharmacy25.ccqdvtisatyp.us-east-2.rds.amazonaws.com/pharmacy";
            return true;
        }
        else{
            PropertiesLoader.jdbcUrl = "jdbc:mariadb://mama.sh:4123/pharmacy";
            return false;
        }
    }
}
