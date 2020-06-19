package Funclayer.exceptions.exceptions;

import java.sql.SQLException;

public class IDException extends SQLException {
    public IDException(String message) {
        super( message );
    }
}
