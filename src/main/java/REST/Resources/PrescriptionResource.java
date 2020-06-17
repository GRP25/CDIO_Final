package REST.Resources;

import java.sql.SQLException;
import java.util.List;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import Datalayer.DTO.*;
import Funclayer.implementation.PrescriptionService;
import Funclayer.interfaces.IPrescriptionService;
import REST.SuccessMessage;

import static Funclayer.exceptions.validation.PrescriptionValidation.validatePrescription;

@Path("Prescriptions")
public class PrescriptionResource {

	IPrescriptionService prescriptionService = new PrescriptionService();

	// Create Prescription function
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response createPrescription(PrescriptionDTO prescriptionDTO) throws SQLException {
		validatePrescription(prescriptionDTO);
		prescriptionService.createPrescription(prescriptionDTO);
		SuccessMessage msg = new SuccessMessage("Created new Prescription", 0, "");
		return Response.status(Response.Status.OK).entity(msg).build();
	}

	// Update prescription
	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	public Response updatePrescription(PrescriptionDTO prescriptionDTO) throws SQLException {
		validatePrescription(prescriptionDTO);
		prescriptionService.updatePrescription(prescriptionDTO);
		SuccessMessage msg = new SuccessMessage("Updated Prescription", 1, "");
		return Response.status(Response.Status.OK).entity(msg).build();
	}

	// Get all Prescription function
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response getPrescriptionList() throws SQLException {
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
	public Response getPrescription(@PathParam("PrescriptionID") int presID) throws SQLException {
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