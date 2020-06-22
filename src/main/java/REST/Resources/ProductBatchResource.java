package REST.Resources;

import java.sql.SQLException;
import java.util.List;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import Datalayer.DTO.ProductBatchDTO;
import Funclayer.exceptions.exceptions.NotProductBatchExeption;
import Funclayer.implementation.ProductBatchService;
import Funclayer.interfaces.IProductBatchService;
import REST.SuccessMessage;

import static Funclayer.exceptions.validation.ProductBatchValidation.*;

/*
* Get productbatch
* Post productbatch
*
* Get productbatch compound
* Post productbatch compound
*/

@Path("ProductBatchs")
public class ProductBatchResource {
    IProductBatchService productBatchService = new ProductBatchService();

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllProducts() throws SQLException {
        List<ProductBatchDTO> productBatchList = productBatchService.getProductBatchDTOList();
        return Response.status(Response.Status.OK).entity(productBatchList).build();
    }

    @Path("/ID/{ProductID}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getProductBatchByID(@PathParam("ProductID") int productBatchId) throws SQLException {
        validateProductBatchID(productBatchId);
        ProductBatchDTO productBatchDTO = productBatchService.getProductBatchDTO(productBatchId);
        return Response.status(Response.Status.OK).entity(productBatchDTO).build();
    }

    // create produkt batch
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response createProductBatch(ProductBatchDTO productBatch) throws SQLException, NotProductBatchExeption {
        productBatchValidationForCreate(productBatch);
        productBatchService.createProductBatch(productBatch);
        SuccessMessage msg = new SuccessMessage("Product batch successfully created", 6000, "https://mama.sh/");
        return Response.status(Response.Status.OK).entity(msg).build();
    }

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public Response updateProductBatch(ProductBatchDTO productBatch) throws SQLException, NotProductBatchExeption {
        productBatchValidationForUpdate(productBatch);
        productBatchService.updateProductBatch(productBatch);
        SuccessMessage msg = new SuccessMessage("Product batch successfully updated", 6001, "https://mama.sh/");
        return Response.status(Response.Status.OK).entity(msg).build();
    }
}