package REST.Resources;

import Datalayer.DTO.commodityDTO;
import REST.Services.Implementation.CommodityService;
import REST.Services.Interfaces.ICommodityService;

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
        commodityDTO commodityItem = commodityService.getCommodity(comID);

        if (commodityItem != null)
            response = Response.status( Response.Status.OK ).entity( commodityItem ).build();
        else
            response = Response.status( Response.Status.BAD_REQUEST ).entity( "Expstion: from CommodityResource.getCommodity" ).build();
        return response;
    }

    @GET
    public Response getCommodityList() throws SQLException {
        Response response;
        List<commodityDTO> commodityList = commodityService.getCommodityList();

        if (commodityList != null)
            response = Response.status( Response.Status.OK ).entity( commodityList ).build();
        else
            response = Response.status( Response.Status.BAD_REQUEST ).entity( "Expstion: from CommodityResource.getCommodityList" ).build();
        return response;
    }

    @POST
    public Response createCommodity(commodityDTO comDTO) throws SQLException {

        Response response;
        String createCommodity = commodityService.createCommodity( comDTO );

        if (createCommodity.equalsIgnoreCase( "Insert query executed successfully"))
            response = Response.status( Response.Status.OK ).entity( createCommodity ).build();
        else
            response = Response.status( Response.Status.BAD_REQUEST ).entity( createCommodity ).build();
        return response;
    }

    @PUT
    public Response updateCommodity(commodityDTO comDTO) throws SQLException {

        Response response;
        String updateCommodity = commodityService.updateCommodity( comDTO );

        if (updateCommodity.equalsIgnoreCase( "Update query executed successfully"))
            response = Response.status( Response.Status.OK ).entity( updateCommodity ).build();
        else
            response = Response.status( Response.Status.BAD_REQUEST ).entity( updateCommodity ).build();
        return response;
    }

    public static void main(String[] args) throws SQLException {


        ICommodityService commodityService = new CommodityService();
        //Test getCommodityBatch
        System.out.println(commodityService.getCommodity( 1 ).getCommodity_id());
        System.out.println(commodityService.getCommodity( 1 ).getCommodity_Name());

        // Test commodityBatchList
//        for (CommodityBatchDTO commodityBatchDTO : commodityBatchService.getCommodityBatchList()) {
//            System.out.print( commodityBatchDTO.getCommodity_id() + " " );
//            System.out.print( commodityBatchDTO.getCommodityBatch_id() + " " );
//            System.out.print( commodityBatchDTO.getWeight() + " " );
//            System.out.print( commodityBatchDTO.getSupplier() + " " );
//           System.out.println();
        //};

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