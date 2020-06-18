package Funclayer.exceptions.exceptions;

import Datalayer.DTO.ProductBatchDTO;

import java.sql.SQLException;

public class NotProductBatchExeption extends SQLException {
    public NotProductBatchExeption(String message){
        super(message);
    }
}
