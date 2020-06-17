package REST.Resources;

import Datalayer.DTO.UserDTO;
import Funclayer.implementation.UserService;
import Funclayer.interfaces.IUserService;

import java.sql.SQLException;

public class testuser {
    //Denne klasse skal slettes
    // Klassen bruges til at tjekke SQLExeptionsMapper
    public static void main(String[] args) {
        IUserService userService = new UserService();
        try {
            UserDTO u = userService.getUser(8);
            System.out.println(u);
        } catch (SQLException throwables) {
            System.out.println(throwables.getErrorCode());
        }
    }
}
