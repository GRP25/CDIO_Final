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


@Path("Prescriptions")
public class PrescriptionResource {

	IPrescriptionService prescriptionService = new PrescriptionService();

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response createPrescription(PrescriptionDTO prescriptionDTO) throws SQLException {
		prescriptionService.createPrescription(prescriptionDTO);
		SuccessMessage msg = new SuccessMessage("Created new Prescription", 31, "https://mama.sh/");
		return Response.status(Response.Status.OK).entity(msg).build();
	}

	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response updatePrescription(PrescriptionDTO prescriptionDTO) throws SQLException {
		prescriptionService.updatePrescription(prescriptionDTO);
		SuccessMessage msg = new SuccessMessage("Updated Prescription", 32, "https://mama.sh");
		return Response.status(Response.Status.OK).entity(msg).build();
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response getPrescriptionList() throws SQLException {
		List<PrescriptionDTO> prescriptionDTOList = prescriptionService.getPrescriptionList();
		return Response.status(Response.Status.OK).entity(prescriptionDTOList).build();
	}

	@Path("/ID/{PrescriptionID}")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response getPrescription(@PathParam("PrescriptionID") int presID) throws SQLException {
		PrescriptionDTO prescriptionDTO = prescriptionService.getPrescription(presID);
		return Response.status(Response.Status.OK).entity(prescriptionDTO).build();
	}

}