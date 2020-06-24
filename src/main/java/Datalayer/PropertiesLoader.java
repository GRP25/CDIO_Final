package Datalayer;
public class PropertiesLoader {
    static String jdbcUrl = "jdbc:mariadb://pharmacy25.ccqdvtisatyp.us-east-2.rds.amazonaws.com:3306/pharmacy";
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
    public static boolean isMain(){
        if (jdbcUrl.equals("jdbc:mariadb://mama.sh:4123/pharmacy")) {
            return true;
        }
        else
            return false;
    }
}
