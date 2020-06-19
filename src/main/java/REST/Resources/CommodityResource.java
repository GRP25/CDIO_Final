package REST.Resources;

import Datalayer.DTO.CommodityDTO;
import Funclayer.implementation.CommodityService;
import Funclayer.interfaces.ICommodityService;
import REST.SuccessMessage;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.sql.SQLException;
import java.util.List;


@Path( "/commodity/" )
@Consumes( MediaType.APPLICATION_JSON )
@Produces( MediaType.APPLICATION_JSON )
public class CommodityResource {

    ICommodityService commodityService = new CommodityService();

    @Path("/{commodity_id}")
    @GET
    public Response getCommodity(@PathParam("commodity_id") int comID) throws SQLException {
        Response response;
        CommodityDTO commodityItem = commodityService.getCommodity(comID);
        response = Response.status( Response.Status.OK ).entity( commodityItem ).build();
        return response;
    }

    @GET
    public Response getCommodityList() throws SQLException {
        Response response;
        List<CommodityDTO> commodityList = commodityService.getCommodityList();
        response = Response.status( Response.Status.OK ).entity( commodityList ).build();
        return response;
    }

    @POST
    public Response createCommodity(CommodityDTO comDTO) throws SQLException {

        Response response;
        commodityService.createCommodity( comDTO );
        SuccessMessage msg = new SuccessMessage("Created successfully", 20, "https://mama.sh/");
        response = Response.status( Response.Status.OK ).entity( msg ).build();
        return response;
    }

    @PUT
    public Response updateCommodity(CommodityDTO comDTO) throws SQLException {
        Response response;
        commodityService.updateCommodity( comDTO );
        SuccessMessage msg = new SuccessMessage("Updated successfully", 20, "https://mama.sh/");
        response = Response.status( Response.Status.OK ).entity( msg ).build();
        return response;
    }

}