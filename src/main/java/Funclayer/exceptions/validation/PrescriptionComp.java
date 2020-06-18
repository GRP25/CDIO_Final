package Funclayer.exceptions.validation;

import Datalayer.DAO.CommodityDAO;
import Datalayer.DAO.PrescriptionCompDAO;
import Datalayer.DTO.PrescriptionCompDTO;
import Datalayer.Interfaces.ICommodityDAO;
import Datalayer.Interfaces.IPrescriptionCompDAO;
import Funclayer.exceptions.exceptions.IDException;
import Funclayer.exceptions.exceptions.ObjectException;
import Funclayer.exceptions.validation.template.Validation;

import java.sql.SQLException;

public class PrescriptionComp extends Validation {

    static IPrescriptionCompDAO prescriptionCompDAO = new PrescriptionCompDAO();

    public static void validatePrescriptionDAOId(int ID) throws SQLException {
        if(!prescriptionCompDAO.exists(idValidator( ID ))){
            throw new IDException("No PrescriptionComp exists with this number as an identification!");
        }
    }

    public static void prescriptionCompValidation(PrescriptionCompDTO prescriptionCompDTO) throws SQLException {

        if (prescriptionCompDAO.exists( idValidator( prescriptionCompDTO.getPrescription_id())))
            throw new ObjectException( "PrescriptionComp id is already exist");

        ICommodityDAO commodityDAO = new CommodityDAO();
        if (!commodityDAO.exists( idValidator( prescriptionCompDTO.getCommodity_id() ) ))
            throw new ObjectException( "Commodity id is not exist" );



        double nomNetto = prescriptionCompDTO.getNomNetto( );
        if (!isDouble( nomNetto ) || !isNomNettoValid( nomNetto ) )
            throw new ObjectException( "Invalid nomNetto Please input number between (0.05 - 20.0)" );



        double tolerance = prescriptionCompDTO.getTolerance();
        if (!isDouble( tolerance ) || !isTolerance( tolerance ))
            throw new ObjectException( "Invalid tolerance please input number between (0.1 - 10.0)" );


    }

    private static boolean isNomNettoValid(double nomNetto) {
        if (nomNetto < 0.05 ||  nomNetto > 20.0  )
            return false;
        return true;
    }

    private static boolean isTolerance(double tolerance) {
        if (tolerance < 0.1 ||  tolerance > 10.0  )
            return false;
        return true;
    }



}