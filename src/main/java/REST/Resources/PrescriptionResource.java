package REST.Resources;

import java.util.List;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import Datalayer.DTO.*;
import REST.Services.Implementation.PrescriptionService;
/*
*   Create Prescription
*   Get prescriptions
*   Get specific presciption by ID
*/
import REST.Services.Interfaces.IPrescriptionService;

@Path("Prescriptions")
public class PrescriptionResource {

    IPrescriptionService prescriptionService = new PrescriptionService();

    // Create Prescription function
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response createPrescription(PrescriptionDTO prescriptionDTO) {
        Response response;

        String createResult = prescriptionService.createPrescription(prescriptionDTO);

        if (createResult.equalsIgnoreCase("Insert query executed successfully")) {
            response = Response.status(Response.Status.OK).entity(prescriptionDTO).build();
        } else {
            response = Response.status(Response.Status.BAD_REQUEST).entity("Error").build();
        }

        return response;
    }

    // Update prescription
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public Response updatePrescription(PrescriptionDTO prescriptionDTO) {
        Response response;

        String updateResult = prescriptionService.updatePrescription(prescriptionDTO);

        if (updateResult.equalsIgnoreCase("Update query executed succesfully")) {
            response = Response.status(Response.Status.OK).entity(prescriptionDTO).build();
        } else {
            response = Response.status(Response.Status.BAD_REQUEST).entity(prescriptionDTO).build();
        }

        return response;
    }

    // Get all Prescription function
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getPrescriptionList() {
        Response response;

        List<PrescriptionDTO> prescriptionDTOList = prescriptionService.getPrescriptionList();

        if (prescriptionDTOList != null) {
            response = Response.status(Response.Status.OK).entity(prescriptionDTOList).build();
        } else {
            response = Response.status(Response.Status.BAD_REQUEST).entity("Error").build();
        }
        return response;
    }

    // Get Spicific Prescription funktion
    @Path("/ID/{PrescriptionID}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getPrescription(@PathParam("PrescriptionID") int presID) {
        Response response;

        PrescriptionDTO prescriptionDTO = prescriptionService.getPrescription(presID);

        if (prescriptionDTO != null) {
            response = Response.status(Response.Status.OK).entity(prescriptionDTO).build();
        } else {
            response = Response.status(Response.Status.BAD_REQUEST).entity("Error").build();
        }

        return response;
    }

}