package Funclayer.exceptions.exceptions;

import java.sql.SQLException;

public class UserException extends SQLException {
    UserException(String message) {
        super(message);
    }
}
