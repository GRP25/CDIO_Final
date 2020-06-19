package Funclayer.exceptions.exceptions;

import java.sql.SQLException;

public class MAPSQLException extends SQLException {
    public MAPSQLException(String reason) {
        super( reason );
    }
}
