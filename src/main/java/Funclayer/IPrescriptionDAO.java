package Funclayer;

import Datalayer.DTO.PrescriptionDTO;

public interface IPrescriptionDAO {
    PrescriptionDTO getPrescription(int prescription_id);

    
}
