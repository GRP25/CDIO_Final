package Funclayer.exceptions;

import Datalayer.Interfaces.IUserDAO;
import Datalayer.DTO.UserDTO;
import Datalayer.DAO.UserDAO;

import java.sql.SQLException;

import static Funclayer.Conversion.cprConversion;
import static Funclayer.Conversion.nameConversion;

public class Validation {
    private static boolean hasStr(String str1, String str2) {
        return str1.matches(".*(?i)" + str2 + ".*");
    }

    private static boolean hasDigit(String str) {
        return str.matches(".*[0-9].*");
    }

    private static boolean hasUppercase(String str) {
        return str.matches(".*[A-Z].*");
    }

    private static boolean hasLowercase(String str) {
        return str.matches(".*[a-z].*");
    }

    private static boolean hasSpecial(String str) {
        return str.matches(".*[!@#$%&*()_+=|<>?{}\\[\\]~-].*");
    }

    private static boolean lengthValidator(int min, int max, String str) {
        return str.length() < min || str.length() > max;
    }

    private static boolean isDateValidator(String date) {
        return date.matches("^(3[01]|[12][0-9]|0[1-9])(1[0-2]|0[1-9])[0-9]{2}$");
    }

    public static String cprValidator(String cpr) throws NotACPRException, SQLException {
        IUserDAO db = new UserDAO();
        System.out.println(cpr);
        System.out.println(cpr.length());
        if (cpr.length() != 10)
            throw new NotACPRException("This is not a cpr number it does not have the right amount of digits" );

        if (!isDateValidator(cpr.substring(0, 6)))
            throw new NotACPRException("This cpr does not contain a valid date");

        if (db.exists(cpr)) {
            throw new NotACPRException("This cpr already exists in the database");
        }
        return cpr;
    }

    public static String nameValidator(String name) throws NotANameException {
        if (hasDigit(name))
            throw new NotANameException("Names can not have numbers. Please put in a real name!");
        if (hasSpecial(name))
            throw new NotANameException("Names can not have special characters. Please put in a real name!");
        if (lengthValidator(1, 25, name))
            throw new NotANameException("The name can only be between 2 and 25 characters");
        else
            return name;
    }

    public static void validateUser(UserDTO user) throws UserException{
        nameValidator(nameConversion(user.getFirstName()));
        nameValidator(nameConversion(user.getSurname()));
        cprValidator(user.getCpr());
    }
}

