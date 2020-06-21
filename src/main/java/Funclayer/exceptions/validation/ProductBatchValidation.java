package Funclayer.exceptions.validation;

import Datalayer.DAO.PrescriptionDAO;
import Datalayer.DAO.ProductBatchDAO;
import Datalayer.DTO.ProductBatchDTO;
import Datalayer.Interfaces.IPrescriptionDAO;
import Datalayer.Interfaces.IProductBatchDAO;
import Funclayer.exceptions.exceptions.DataLayerException;
import Funclayer.exceptions.exceptions.NotProductBatchExeption;
import Funclayer.exceptions.exceptions.ObjectException;
import Funclayer.exceptions.validation.template.Validation;

import java.sql.SQLException;

public class ProductBatchValidation extends Validation {
    static IProductBatchDAO productBatchDAO = new ProductBatchDAO();

    public static void validateProductBatchID(int ID) throws SQLException {
        if (ID == 0)
            throw new ObjectException("No ProductBatch exists with this ProductBatch ID");
        if (!productBatchDAO.exists(ID)) {
            throw new DataLayerException("No ProductBatch exists with this number as an identification!");
        }
    }

    public static void productBatchValidationForCreate(ProductBatchDTO productBatchDTO) throws NotProductBatchExeption, SQLException {
        /*if (!isDateValidator( String.valueOf( productBatchDTO.getStartDate() ) ))
            throw new DateTimeException("Invalid start-date");
        if (!isDateValidator( String.valueOf( productBatchDTO.getEndDate() ) ))
            throw new DateTimeException("Invalid end-date");*/ // TODO Need explanation
        statusValidator(productBatchDTO.getStatus());
        if (productBatchDAO.exists(idValidator(productBatchDTO.getProductBatch_id())))
            throw new ObjectException("ProductBatch id is already exist");
        IPrescriptionDAO prescriptionDAO = new PrescriptionDAO();
        if (!prescriptionDAO.exists(idValidator(productBatchDTO.getPrescription_id())))
            throw new ObjectException("Prescription id is not exist");
    }

    public static void productBatchValidationForUpdate(ProductBatchDTO productBatchDTO) throws NotProductBatchExeption, SQLException {
        /*if (!isDateValidator( String.valueOf( productBatchDTO.getStartDate() ) ))
            throw new DateTimeException("Invalid start-date");
        if (!isDateValidator( String.valueOf( productBatchDTO.getEndDate() ) ))
            throw new DateTimeException("Invalid end-date");*/ // TODO Need explanation
        statusValidator(productBatchDTO.getStatus());
        IPrescriptionDAO prescriptionDAO = new PrescriptionDAO();
        if (!prescriptionDAO.exists(idValidator(productBatchDTO.getPrescription_id())))
            throw new ObjectException("Prescription id is not exist");
    }
}