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
        CommodityDTO commodityItem = commodityService.getCommodity(comID);
        return Response.status( Response.Status.OK ).entity( commodityItem ).build();
    }

    @GET
    public Response getCommodityList() throws SQLException {
        List<CommodityDTO> commodityList = commodityService.getCommodityList();
        return Response.status( Response.Status.OK ).entity( commodityList ).build();
    }

    @POST
    public Response createCommodity(CommodityDTO comDTO) throws SQLException {
        commodityService.createCommodity( comDTO );
        SuccessMessage msg = new SuccessMessage("Created successfully", 4000, "https://mama.sh/");
        return Response.status( Response.Status.OK ).entity( msg ).build();
    }

    @PUT
    public Response updateCommodity(CommodityDTO comDTO) throws SQLException {
        commodityService.updateCommodity( comDTO );
        SuccessMessage msg = new SuccessMessage("Updated successfully", 4001, "https://mama.sh/");
        return Response.status( Response.Status.OK ).entity( msg ).build();
    }

}