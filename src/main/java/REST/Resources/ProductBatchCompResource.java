package REST.Resources;

import Datalayer.DTO.ProductBatchCompDTO;
import Funclayer.implementation.ProductBatchCompService;
import Funclayer.interfaces.IProductBatchCompService;
import REST.SuccessMessage;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import java.sql.SQLException;
import java.util.List;

@Path("productbatchcomp")
public class ProductBatchCompResource {
    IProductBatchCompService productBatchCompService = new ProductBatchCompService();

    @Path("/component")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getProductBatchComp(@QueryParam("productBatchId") int productBatch_id,
            @QueryParam("commodityBatchId") int commodityBatch_id) throws SQLException {
        ProductBatchCompDTO productBatchComp;
        productBatchComp = productBatchCompService.getProductBatchComp(productBatch_id,commodityBatch_id);
        return Response.status(Response.Status.OK).entity(productBatchComp).build();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllProductBatchCompList() throws SQLException {
        List<ProductBatchCompDTO> productBatchCompList = productBatchCompService.getProductBatchCompList();
        return Response.status(Response.Status.OK).entity(productBatchCompList).build();
    }

    @Path("/ID/{ProductID}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getProductBatchCompListByID(@PathParam("ProductID") int productBatch_id) throws SQLException {
        List<ProductBatchCompDTO> productBatchCompList;
        productBatchCompList = productBatchCompService.getProductBatchCompList(productBatch_id);
        return Response.status(Response.Status.OK).entity(productBatchCompList).build();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response createProductBatchComp(ProductBatchCompDTO productBatchCompDTO) throws SQLException {
        productBatchCompService.createProductBatchComp(productBatchCompDTO);
        SuccessMessage msg = new SuccessMessage("ProductBatchComp succesfully created", 6010, "http://backup.mama.sh/cdio/api/");
        return Response.status(Response.Status.OK).entity(msg).build();
    }

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response updateProductBatchComp(ProductBatchCompDTO productBatchComp) throws SQLException {
        productBatchCompService.updateProductBatchComp(productBatchComp);
        SuccessMessage msg = new SuccessMessage("ProductBatchComp succesfully updated", 6011, "http://backup.mama.sh/cdio/api/");
        return Response.status(Response.Status.OK).entity(msg).build();
    }
}
