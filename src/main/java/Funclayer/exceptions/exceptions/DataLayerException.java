package Funclayer.exceptions.exceptions;

import java.sql.SQLException;

public class DataLayerException extends SQLException {
    public DataLayerException(String message) {
        super(message);
    }
}
