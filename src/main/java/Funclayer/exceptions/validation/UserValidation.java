package Funclayer.exceptions.validation;

import Datalayer.Interfaces.IUserDAO;
import Funclayer.exceptions.exceptions.DataLayerException;
import Funclayer.exceptions.exceptions.NotACPRException;
import Funclayer.exceptions.exceptions.NotANameException;
import Funclayer.exceptions.exceptions.UserException;
import Funclayer.exceptions.validation.template.Validation;
import Datalayer.DTO.UserDTO;
import Datalayer.DAO.UserDAO;

import java.sql.SQLException;

import static Funclayer.Conversion.cprConversion;
import static Funclayer.Conversion.nameConversion;

public class UserValidation extends Validation {
    private static boolean hasStr(String str1, String str2) {
        return str1.matches(".*(?i)" + str2 + ".*");
    }

    private static boolean hasUppercase(String str) {
        return str.matches(".*[A-Z].*");
    }

    private static boolean hasLowercase(String str) {
        return str.matches(".*[a-z].*");
    }

    private static boolean isDateValidator(String date) {
        return date.matches("^(3[01]|[12][0-9]|0[1-9])(1[0-2]|0[1-9])[0-9]{2}$");
    }

    public static String cprValidator(String cpr) throws NotACPRException, SQLException {
        IUserDAO db = new UserDAO();
        if (cpr.length() != 10)
            throw new NotACPRException("This is not a cpr number it does not have the right amount of digits");

        if (!isDateValidator(cpr.substring(0, 6)))
            throw new NotACPRException("This cpr does not contain a valid date");

        if (db.exists(cpr)) {
            throw new NotACPRException("This cpr already exists in the database");
        }
        return cpr;
    }

    public static void validateUser(UserDTO user) throws UserException, SQLException {
        nameValidator(nameConversion(user.getFirstName()));
        nameValidator(nameConversion(user.getSurname()));
        cprValidator(user.getCpr());
    }

    public static void validateUserId(int id) throws SQLException {
        IUserDAO db = new UserDAO();
        if (!db.exists(id))
            throw new DataLayerException("No user exists with this number as an identification!");
    }
}
