package Funclayer.exceptions.exceptions;

import java.sql.SQLException;

public class ObjectException extends SQLException {
    public ObjectException(String reason) {
        super( reason );
    }
}
