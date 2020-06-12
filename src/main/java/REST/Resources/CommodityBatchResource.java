package REST.Resources;

import Datalayer.DTO.CommodityBatchDTO;
import Funclayer.implementation.CommodityBatchService;
import Funclayer.interfaces.ICommodityBatchService;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;


import java.sql.SQLException;
import java.util.List;

@Path( "commodityBatch" )
public class CommodityBatchResource {

    ICommodityBatchService commodityBatchService = new CommodityBatchService();

    @GET
    @Path("{commodityBatch_id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getCommodityBatch(@PathParam( "commodityBatch_id" ) int commodityBatch_id) throws SQLException {

        Response response;
        CommodityBatchDTO commodityBatchDTO = commodityBatchService.getCommodityBatch( commodityBatch_id );

        if (commodityBatchDTO != null)
            response = Response.status( Response.Status.OK ).entity( commodityBatchDTO ).build();
        else
            response = Response.status( Response.Status.OK ).entity( "Exception: from CommodityBatchResource.getCommodityBatch" ).build();

        return response;

    }

    @GET
    @Path( "list/{commodity_id}" )
    @Produces(MediaType.APPLICATION_JSON)
    public Response getCommodityBatchList(@PathParam( "commodity_id" ) int commodity_id) throws SQLException {

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
    public Response getCommodityBatchList() throws SQLException {

        Response response;
        List<CommodityBatchDTO> commodityBatchDTOList = commodityBatchService.getCommodityBatchList();

        if (commodityBatchDTOList != null)
            response = Response.status( Response.Status.OK ).entity( commodityBatchDTOList ).build();
        else
            response = Response.status( Response.Status.BAD_REQUEST ).entity( "Exception: from CommodityBatchResource.getCommodityBatchList" ).build();

        return response;

    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response createCommodityBatch(CommodityBatchDTO commodityBatchDTO) throws SQLException {

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
    public Response updateCommodityBatch(CommodityBatchDTO commodityBatchDTO) throws SQLException {

        Response response;
        String updateResult = commodityBatchService.updateCommodityBatch( commodityBatchDTO );

        if (updateResult.equalsIgnoreCase( "Update query executed successfully" ))
            response = Response.status( Response.Status.OK ).entity( updateResult ).build();
        else
            response = Response.status( Response.Status.BAD_REQUEST ).entity( updateResult ).build();

        return response;

    }



    public static void main(String[] args) throws SQLException { // Todo Delete this later
        ICommodityBatchService commodityBatchService = new CommodityBatchService();
        // Test getCommodityBatch
//        System.out.println(commodityBatchService.getCommodityBatch( 1 ).getSupplier());


        // Test commodityBatchList
//        for (CommodityBatchDTO commodityBatchDTO : commodityBatchService.getCommodityBatchList()) {
//            System.out.print( commodityBatchDTO.getCommodity_id() + " " );
//            System.out.print( commodityBatchDTO.getCommodityBatch_id() + " " );
//            System.out.print( commodityBatchDTO.getWeight() + " " );
//            System.out.print( commodityBatchDTO.getSupplier() + " " );
//            System.out.println();
//        };

        // Test commodityBatchList
//        for (CommodityBatchDTO commodityBatchDTO : commodityBatchService.getCommodityBatchList(1)) {
//            System.out.print( commodityBatchDTO.getCommodity_id() + " " );
//            System.out.print( commodityBatchDTO.getCommodityBatch_id() + " " );
//            System.out.print( commodityBatchDTO.getWeight() + " " );
//            System.out.print( commodityBatchDTO.getSupplier() + " " );
//            System.out.println();
//        };


        // Test updateCommodityBatch
//        CommodityBatchDTO commodityBatchDAO1 = new CommodityBatchDTO(2,1,8.4,"UpdateMethod");
//        System.out.println(commodityBatchService.updateCommodityBatch( commodityBatchDAO1 ));

        // Test createCommodityBatch
//        CommodityBatchDTO commodityBatchDAO1 = new CommodityBatchDTO(4,1,5.4,"CreateMethod");
//        System.out.println(commodityBatchService.createCommodityBatch( commodityBatchDAO1 ));
    }

}
