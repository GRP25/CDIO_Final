package REST.Resources;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.Produces;

import Datalayer.DTO.PrescriptionCompDTO;
import Funclayer.interfaces.IPrescriptionCompService;
import Funclayer.implementation.PrescriptionCompService;
import REST.SuccessMessage;

import java.sql.SQLException;
import java.util.List;

@Path("PrescriptionComp")
public class PrescriptionCompResource {

	IPrescriptionCompService prescriptionCompService = new PrescriptionCompService();

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response createPrescriptionComp(PrescriptionCompDTO presCompDTO) throws SQLException {
		prescriptionCompService.createPrescriptionComp(presCompDTO);
		SuccessMessage msg = new SuccessMessage("Prescriptioncomp Successfully created", 5010, "http://backup.mama.sh/cdio/api/");
		return Response.status(Response.Status.OK).entity(msg).build();
	}

	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response updatePrescriptionComp(PrescriptionCompDTO presCompDTO) throws SQLException {
		prescriptionCompService.updatePrescriptionComp(presCompDTO);
		SuccessMessage msg = new SuccessMessage("Prescriptioncomp Successfully updated", 5011, "http://backup.mama.sh/cdio/api/");
		return Response.status(Response.Status.OK).entity(msg).build();
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response getPrescriptionCompList() throws SQLException {
		List<PrescriptionCompDTO> prescriptionCompDTOList = prescriptionCompService.getPrescriptionCompList();
		return Response.status(Response.Status.OK).entity(prescriptionCompDTOList).build();
	}

	@Path("/{presID}")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response getPrescriptionCompList(@PathParam("presID") int presID) throws SQLException {
		List<PrescriptionCompDTO> prescriptionCompList = prescriptionCompService.getPrescriptionCompList(presID);
		return Response.status(Response.Status.OK).entity(prescriptionCompList).build();
	}

	@Path("/component")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response getPrescriptionComp(@QueryParam("presID") int presID, @QueryParam("comID") int comID)
			throws SQLException {
		PrescriptionCompDTO prescriptionCompDTO = prescriptionCompService.getPrescriptionComp(presID, comID);
		return Response.status(Response.Status.OK).entity(prescriptionCompDTO).build();
	}
}