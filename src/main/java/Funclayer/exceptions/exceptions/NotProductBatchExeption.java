package Funclayer.exceptions.exceptions;

import Datalayer.DTO.ProductBatchDTO;

public class NotProductBatchExeption extends Exception {
    public NotProductBatchExeption(String message){
        super(message);
    }
}
