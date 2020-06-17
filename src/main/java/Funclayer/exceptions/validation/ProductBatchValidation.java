package Funclayer.exceptions.validation;

import Datalayer.DAO.ProductBatchDAO;
import Datalayer.DTO.ProductBatchDTO;
import Datalayer.Interfaces.IProductBatchDAO;
import Funclayer.exceptions.exceptions.DataLayerException;
import Funclayer.exceptions.exceptions.NotAStatusException;
import Funclayer.exceptions.exceptions.NotProductBatchExeption;
import Funclayer.exceptions.validation.template.Validation;

import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.DateTimeException;

public class ProductBatchValidation extends Validation {

    public static void validateProductBatchID(int ID) throws SQLException {
        IProductBatchDAO productBatchDAO = new ProductBatchDAO();
        if(!productBatchDAO.exists(ID)){
            throw new DataLayerException("No ProductBatch exists with this number as an identification!");
        }
    }

    public static void productBatchValidation(ProductBatchDTO productBatchDTO) throws NotProductBatchExeption, SQLException {

        DateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd hh:mm:ss");
        String tempStartDate = dateFormat.format(productBatchDTO.getStartDate());
        String tempEndDate = dateFormat.format(productBatchDTO.getEndDate());

        if (!isDateValidator(tempStartDate))
            throw new DateTimeException("Invalid start-date");

        if (!isDateValidator(tempEndDate))
            throw new DateTimeException("Invalid end-date");

        statusValidator(productBatchDTO.getStatus());

        validateProductBatchID(productBatchDTO.getProductBatch_id());



    }




}