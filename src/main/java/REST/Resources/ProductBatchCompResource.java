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

    // get product (int product id, int commodity id)
    @Path("/component")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getProductBatchComp(@QueryParam("productBatchId") int productBatch_id,
            @QueryParam("commodityBatchId") int commodityBatch_id) throws SQLException {
        Response response;
        ProductBatchCompDTO productBatchComp = productBatchCompService.getProductBatchComp(productBatch_id,
                commodityBatch_id);
        response = Response.status(Response.Status.OK).entity(productBatchComp).build();
        return response;
    }

    // get productbatchcomp list
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllProductBatchCompList() throws SQLException {
        Response response;
        List<ProductBatchCompDTO> productBatchCompList = productBatchCompService.getProductBatchCompList();
        response = Response.status(Response.Status.OK).entity(productBatchCompList).build();
        return response;
    }

    // get productBatch comp list with id
    @Path("/ID/{ProductID}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getProductBatchCompListByID(@PathParam("ProductID") int productBatch_id) throws SQLException {

        Response response;
        List<ProductBatchCompDTO> productBatchCompList = productBatchCompService
                .getProductBatchCompList(productBatch_id);
        response = Response.status(Response.Status.OK).entity(productBatchCompList).build();
        return response;
    }

    // create productbatchcomp
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response createProductBatchComp(ProductBatchCompDTO productBatchCompDTO) throws SQLException {
        Response response;
        productBatchCompService.createProductBatchComp(productBatchCompDTO);
        SuccessMessage msg = new SuccessMessage("ProductBatchComp succesfully created", 10, "https://mama.sh/");
        response = Response.status(Response.Status.OK).entity(msg).build();
        return response;
    }

    // update productbatchcomp

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response updateProductBatchComp(ProductBatchCompDTO productBatchComp) throws SQLException {
        Response response;
        productBatchCompService.updateProductBatchComp(productBatchComp);
        SuccessMessage msg = new SuccessMessage("ProductBatchComp succesfully updated", 11, "https://mama.sh/");
        response = Response.status(Response.Status.OK).entity(msg).build();
        return response;
    }
}
