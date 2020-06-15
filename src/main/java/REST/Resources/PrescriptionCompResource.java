package REST.Resources;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.Produces;

import Datalayer.DTO.PrescriptionCompDTO;
import Funclayer.interfaces.IPrescriptionCompService;
import Funclayer.implementation.PrescriptionCompService;

import java.sql.SQLException;
import java.util.List;

@Path("PrescriptionComp")
public class PrescriptionCompResource {

	IPrescriptionCompService prescriptionCompService = new PrescriptionCompService();

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)

	public Response createPrescriptionComp(PrescriptionCompDTO presCompDTO) throws SQLException {
		Response response;

		String createResult = prescriptionCompService.createPrescriptionComp(presCompDTO);

		if (createResult.equalsIgnoreCase("Insert query executed successfully")) {
			response = Response.status(Response.Status.OK).entity(createResult).build();
		} else {
			response = Response.status(Response.Status.BAD_REQUEST).entity(createResult).build();
		}

		return response;
	}

	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response updatePrescriptionComp(PrescriptionCompDTO presCompDTO) throws SQLException {
		Response response;

		String updateResult = prescriptionCompService.updatePrescriptionComp(presCompDTO);

		if (updateResult.equalsIgnoreCase("Insert query executed successfully")) {
			response = Response.status(Response.Status.OK).entity(updateResult).build();
		} else {
			response = Response.status(Response.Status.BAD_REQUEST).entity(updateResult).build();
		}

		return response;
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response getPrescriptionCompList() throws SQLException {
		Response response;
		List<PrescriptionCompDTO> prescriptionCompDTOList = prescriptionCompService.getPrescriptionCompList();

		if (prescriptionCompDTOList != null) {
			response = Response.status(Response.Status.OK).entity(prescriptionCompDTOList).build();

		} else {
			response = Response.status(Response.Status.OK).entity("Error").build();
		}
		return response;
	}

	// get comp list
	@Path("/{presID}")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response getPrescriptionCompList(@PathParam("presID") int presID) throws SQLException {
		Response response;

		List<PrescriptionCompDTO> prescriptionCompList = prescriptionCompService.getPrescriptionCompList(presID);

		if (prescriptionCompList != null) {
			response = Response.status(Response.Status.OK).entity(prescriptionCompList).build();

		} else {
			response = Response.status(Response.Status.OK).entity("Error").build();
		}
		return response;
	}

	// example query = /prescriptionComp/component?presID=10&comID=81
	@Path("/component/")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response getPrescriptionComp(@QueryParam("presID") int presID, @QueryParam("comID") int comID)
			throws SQLException {
		Response response;

		PrescriptionCompDTO prescriptionCompDTO = prescriptionCompService.getPrescriptionComp(presID, comID);

		if (prescriptionCompDTO != null) {
			response = Response.status(Response.Status.OK).entity(prescriptionCompDTO).build();

		} else {
			response = Response.status(Response.Status.OK).entity("Error").build();

		}

		return response;
	}
}