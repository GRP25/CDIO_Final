package Funclayer.exceptions.exceptions;

import java.sql.SQLException;

public class MapSQLExceptionTest extends SQLException {
    public MapSQLExceptionTest(String reason) {
        super( reason );
    }
}
