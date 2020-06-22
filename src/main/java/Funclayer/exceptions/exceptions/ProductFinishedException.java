package Funclayer.exceptions.exceptions;

import java.sql.SQLException;

public class ProductFinishedException extends SQLException {
    public ProductFinishedException(String message) {
        super(message);
    }
}
