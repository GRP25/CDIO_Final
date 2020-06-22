package REST.Resources;

import Datalayer.DTO.CommodityBatchDTO;
import Funclayer.implementation.CommodityBatchService;
import Funclayer.interfaces.ICommodityBatchService;
import REST.SuccessMessage;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.sql.SQLException;
import java.util.List;

@Path("commodityBatch")
public class CommodityBatchResource {
    ICommodityBatchService commodityBatchService = new CommodityBatchService();

    @GET
    @Path("{commodityBatch_id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getCommodityBatch(@PathParam("commodityBatch_id") int commodityBatch_id) throws SQLException {
        CommodityBatchDTO commodityBatchDTO = commodityBatchService.getCommodityBatch(commodityBatch_id);
        return Response.status(Response.Status.OK).entity(commodityBatchDTO).build();
    }

    @GET
    @Path("list/{commodity_id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getCommodityBatchList(@PathParam("commodity_id") int commodity_id) throws SQLException {
        List<CommodityBatchDTO> commodityBatchDTOList = commodityBatchService.getCommodityBatchList(commodity_id);
        return Response.status(Response.Status.OK).entity(commodityBatchDTOList).build();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getCommodityBatchList() throws SQLException {
        List<CommodityBatchDTO> commodityBatchDTOList = commodityBatchService.getCommodityBatchList();
        return Response.status(Response.Status.OK).entity(commodityBatchDTOList).build();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response createCommodityBatch(CommodityBatchDTO commodityBatchDTO) throws SQLException {
        commodityBatchService.createCommodityBatch(commodityBatchDTO);
        SuccessMessage msg = new SuccessMessage("Commodity batch successfully created", 4010, "https://mama.sh");
        return Response.status(Response.Status.OK).entity(msg).build();
    }

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response updateCommodityBatch(CommodityBatchDTO commodityBatchDTO) throws SQLException {
        commodityBatchService.updateCommodityBatch(commodityBatchDTO);
        SuccessMessage msg = new SuccessMessage("Commodity batch successfully updated", 4011, "https://mama.sh");
        return Response.status(Response.Status.OK).entity(msg).build();
    }
}
