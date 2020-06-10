package REST;

import java.util.ArrayList;

import javax.print.attribute.standard.Media;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

import Datalayer.DAO.PrescriptionCompDAO;
import Datalayer.Interfaces.IPrescriptionCompDAO;
import Datalayer.DTO.*;

/* 
*   Create/add Prescription comp
*   Get Prescription comp list by PresID
*   
**/

@Path("PrescriptionComp")
public class PrescriptionCompResource {
    
    IPrescriptionCompDAO presCompDAO = new PrescriptionCompDAO();

    // add Prescription Compount
    @Path("/Add")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public void addPrescriptionComp(PrescriptionCompDTO presCompDTO) {
        presCompDAO.createPrescriptionComp(presCompDTO);
    }

    // get comp list
    @Path("/{PresID}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public ArrayList<PrescriptionCompDTO> getPrescriptionCompList(@PathParam("PresID") int presID) {
        return presCompDAO.getPrescriptionCompList(presID);
    }

}