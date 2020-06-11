package REST.Resources;

import Datalayer.DTO.CommodityBatchDTO;
import REST.Services.Implementation.CommodityBatchService;
import REST.Services.Interfaces.ICommodityBatchService;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;


import java.util.List;

@Path( "commodityBatch" )
public class CommodityBatchResource {

    ICommodityBatchService commodityBatchService = new CommodityBatchService();

    @GET
    @Path("{commodityBatch_id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getCommodityBatch(@PathParam( "commodityBatch_id" ) int commodityBatch_id){

        Response response;
        CommodityBatchDTO commodityBatchDTO = commodityBatchService.getCommodityBatch( commodityBatch_id );

        if (commodityBatchDTO != null)
            response = Response.status( Response.Status.OK ).entity( commodityBatchDTO ).build();
        else
            response = Response.status( Response.Status.OK ).entity( "Exception: from CommodityBatchResource.getCommodityBatch" ).build();

        return response;

    }

    @GET
    @Path( "{commodity_id}" )
    @Produces(MediaType.APPLICATION_JSON)
    public Response getCommodityBatchList(@PathParam( "commodity_id" ) int commodity_id) {

        Response response;
        List<CommodityBatchDTO> commodityBatchDTOList = commodityBatchService.getCommodityBatchList(commodity_id);

        if (commodityBatchDTOList != null)
            response = Response.status( Response.Status.OK ).entity( commodityBatchDTOList ).build();
        else
            response = Response.status( Response.Status.BAD_REQUEST ).entity( "Exception: from CommodityBatchResource.getCommodityBatchList_withParameter" ).build();

        return response;

    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getCommodityBatchList() {

        Response response;
        List<CommodityBatchDTO> commodityBatchDTOList = commodityBatchService.getCommodityBatchList();

        if (commodityBatchDTOList != null)
            response = Response.status( Response.Status.OK ).entity( commodityBatchDTOList ).build();
        else
            response = Response.status( Response.Status.BAD_REQUEST ).entity( "Exception: from CommodityBatchResource.getCommodityBatchList" ).build();

        return response;

    }

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response createCommodityBatch(CommodityBatchDTO commodityBatchDTO) {

        Response response;
        String createResult = commodityBatchService.createCommodityBatch( commodityBatchDTO );

        if (createResult.equalsIgnoreCase( "Insert query executed successfully" ))
            response = Response.status( Response.Status.OK ).entity( createResult ).build();
        else
            response = Response.status( Response.Status.BAD_REQUEST ).entity( createResult ).build();

        return response;

    }


    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response updateCommodityBatch(CommodityBatchDTO commodityBatchDTO) {

        Response response;
        String updateResult = commodityBatchService.updateCommodityBatch( commodityBatchDTO );

        if (updateResult.equalsIgnoreCase( "Update query executed successfully" ))
            response = Response.status( Response.Status.OK ).entity( updateResult ).build();
        else
            response = Response.status( Response.Status.BAD_REQUEST ).entity( updateResult ).build();

        return response;

    }

}
