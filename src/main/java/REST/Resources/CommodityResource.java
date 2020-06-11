package REST.Resources;

import Datalayer.DTO.commodityDTO;
import REST.Services.Implementation.CommodityService;
import REST.Services.Interfaces.ICommodityService;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;


@Path( "/commodity/" )
@Consumes( MediaType.APPLICATION_JSON )
@Produces( MediaType.APPLICATION_JSON )
public class CommodityResource {

    ICommodityService commodityService = new CommodityService();

    @Path("/{commodity_id}")
    @GET
    public Response getCommodity(@PathParam("commodity_id") int comID) {
        Response response;
        commodityDTO commodityItem = commodityService.getCommodity(comID);

        if (commodityItem != null)
            response = Response.status( Response.Status.OK ).entity( commodityItem ).build();
        else
            response = Response.status( Response.Status.BAD_REQUEST ).entity( "Expstion: from CommodityResource.getCommodity" ).build();
        return response;
    }

    @GET
    public Response getCommodityList() {
        Response response;
        List<commodityDTO> commodityList = commodityService.getCommodityList();

        if (commodityList != null)
            response = Response.status( Response.Status.OK ).entity( commodityList ).build();
        else
            response = Response.status( Response.Status.BAD_REQUEST ).entity( "Expstion: from CommodityResource.getCommodityList" ).build();
        return response;
    }

    @POST
    public Response createCommodity(commodityDTO comDTO) {

        Response response;
        String createCommodity = commodityService.createCommodity( comDTO );

        if (createCommodity.equalsIgnoreCase( "Insert query executed successfully"))
            response = Response.status( Response.Status.OK ).entity( createCommodity ).build();
        else
            response = Response.status( Response.Status.BAD_REQUEST ).entity( createCommodity ).build();
        return response;
    }

    @PUT
    public Response updateCommodity(commodityDTO comDTO) {

        Response response;
        String updateCommodity = commodityService.updateCommodity( comDTO );

        if (updateCommodity.equalsIgnoreCase( "Update query executed successfully"))
            response = Response.status( Response.Status.OK ).entity( updateCommodity ).build();
        else
            response = Response.status( Response.Status.BAD_REQUEST ).entity( updateCommodity ).build();
        return response;
    }


}