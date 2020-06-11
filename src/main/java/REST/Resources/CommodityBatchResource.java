package REST.Resources;

import Datalayer.DTO.CommodityBatchDTO;
import REST.Services.Implementation.CommodityBatchService;
import REST.Services.Interfaces.ICommodityBatchService;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;


import java.util.List;

@Path( "/commodityBatch/" )
public class CommodityBatchResource {

    ICommodityBatchService commodityBatchService = new CommodityBatchService();

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getCommodityBatchList() {
        Response response;
        List<CommodityBatchDTO> commodityBatchDTOList = commodityBatchService.getCommodityBatchList();

        if (commodityBatchDTOList != null)
            response = Response.status( Response.Status.OK ).entity( commodityBatchDTOList ).build();
        else
            response = Response.status( Response.Status.BAD_REQUEST ).entity( "Expstion: from CommodityBatchResource.getCommodityBatchList" ).build();

        return response;
    }

    @PUT
    @Consumes( MediaType.APPLICATION_JSON )
    @Produces ( MediaType.APPLICATION_JSON )
    public Response createCommodityBatch(CommodityBatchDTO commodityBatchDTO) {

        Response response;
        String createResult = commodityBatchService.createCommodityBatch( commodityBatchDTO );

        if (createResult.equalsIgnoreCase( "Insert query executed successfully" ))
            response = Response.status( Response.Status.OK ).entity( createResult ).build();
        else
            response = Response.status( Response.Status.BAD_REQUEST ).entity( createResult ).build();

        return response;
    }

}
