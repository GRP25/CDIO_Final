package Funclayer.exceptions.validation;

import Datalayer.Interfaces.IUserDAO;
import Funclayer.exceptions.exceptions.*;
import Funclayer.exceptions.validation.template.Validation;
import Datalayer.DTO.UserDTO;
import Datalayer.DAO.UserDAO;

import java.sql.SQLException;

import static Funclayer.Conversion.nameConversion;

public class UserValidation extends Validation {
    static  IUserDAO db = new UserDAO();

    private static boolean hasUppercase(String str) {
        return str.matches(".*[A-Z].*");
    }

    private static boolean hasLowercase(String str) {
        return str.matches(".*[a-z].*");
    }

    private static void initialsValidator(String ini) throws SQLException {
        if(ini.length() < 2 || ini.length() > 4)
            throw new ObjectException("Invalid initials input, please input between 2 - 4 characters");
    }

    public static String cprValidator(String cpr) throws  SQLException {
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

    public static void validateUserForCreate(UserDTO user) throws SQLException {
        nameValidator(nameConversion(user.getFirstName()));
        nameValidator(nameConversion(user.getSurname()));
        cprValidator(user.getCpr());
        initialsValidator(user.getInitials());
        statusValidator(user.getStatus());
        if (db.exists( user.getUserID() ))
            throw new IDException( "User Id is already exist" );

    }

    public static void validateUserForUpdate(UserDTO user) throws SQLException {
        nameValidator(nameConversion(user.getFirstName()));
        nameValidator(nameConversion(user.getSurname()));
        initialsValidator(user.getInitials());
        statusValidator(user.getStatus());
    }

    public static void validateUserId(int id) throws SQLException {
        if (!db.exists(id))
            throw new DataLayerException("No user exists with this number as an identification!");
    }

    public static void statusValidator(int status) throws NotAStatusException {
        if (status > 1 && status < 0) {
            throw new NotAStatusException("Not a Valid status, please make sure status's box is checked or input status = 1  ");
        }
    }


}
