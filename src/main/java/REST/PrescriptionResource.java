package REST;

import java.util.ArrayList;

import javax.print.attribute.standard.Media;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

import Datalayer.DAO.*;
import Datalayer.DTO.*;
import Datalayer.Interfaces.IPrescriptionCompDAO;
import Datalayer.Interfaces.IPrescriptionDAO;
/*
*   Create Prescription
*   Get prescriptions
*   Get specific presciption by ID
*/


@Path("Prescriptions")
public class PrescriptionResource {
    
    IPrescriptionDAO presDAO = new PrescriptionDAO();
    IPrescriptionCompDAO presCompDAO = new PrescriptionCompDAO();

    // Create Prescription function
    //@Path("/Create")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public void createPrescription(PrescriptionDTO presDTO) {
        presDAO.createPrescription(presDTO);
    }

    // Get all Prescription function
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public ArrayList<PrescriptionDTO> getAllPrescription() {
        return presDAO.getPrescriptionList();            
    }


    // Get Spicific Prescription funktion
    @Path("/ID/{PrescriptionID}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public PrescriptionDTO getPrescription(@PathParam("PrescriptionID") int presID) {
        return presDAO.getPrescription(presID);
   }


   // ---------------------------- Compound ------------------------------------
   // add Prescription Compount
   @Path("/Comp")
   @POST
   @Consumes(MediaType.APPLICATION_JSON)
   public void addPrescriptionComp(PrescriptionCompDTO presCompDTO) {
       presCompDAO.createPrescriptionComp(presCompDTO);
   }


   // get comp list
   @Path("/Comp/{PresID}")
   @GET
   @Produces(MediaType.APPLICATION_JSON)
   public ArrayList<PrescriptionCompDTO> getPrescriptionCompList(@PathParam("PresID") int presID) {
       return presCompDAO.getPrescriptionCompList(presID);
   }
   
}