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

import static Funclayer.exceptions.validation.ProductBatchValidation.productBatchValidation;
import static Funclayer.exceptions.validation.ProductBatchValidation.validateProductBatchID;

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

    // get all product batches
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllProducts() throws SQLException {
        Response response;

        List<ProductBatchDTO> productBatchList = productBatchService.getProductBatchDTOList();

        if (productBatchList != null) {
            response = Response.status(Response.Status.OK).entity(productBatchList).build();
        } else {
            response = Response.status(Response.Status.BAD_REQUEST).entity("Error").build();

        }
        return response;
    }

    // get specific product batch
    @Path("/ID/{ProductID}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getProductBatchByID(@PathParam("ProductID") int productBatchId) throws SQLException {
        validateProductBatchID(productBatchId);

        Response response;
        ProductBatchDTO productBatchDTO = productBatchService.getProductBatchDTO(productBatchId);

        response = Response.status(Response.Status.OK).entity(productBatchDTO).build();

        return response;
    }

    // create produkt batch
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response createProductBatch(ProductBatchDTO productBatch) throws SQLException, NotProductBatchExeption {
        productBatchValidation(productBatch);

        Response response;
        String createResult = productBatchService.createProductBatch(productBatch);

        if (createResult.equalsIgnoreCase("Insert query executed successfully")) {
            response = Response.status(Response.Status.OK).entity(productBatch).build();

        } else {
            response = Response.status(Response.Status.BAD_REQUEST).entity("Error").build();
        }
        return response;
    }

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public Response updateProductBatch(ProductBatchDTO productBatch) throws SQLException, NotProductBatchExeption {
        productBatchValidation(productBatch);

        Response response;
        String updateResult = productBatchService.updateProductBatch(productBatch);

        if (updateResult.equalsIgnoreCase("Update query executed successfully")) {
            response = Response.status(Response.Status.OK).entity(productBatch).build();
        } else {
            response = Response.status(Response.Status.BAD_REQUEST).entity(productBatch).build();
        }

        return response;
    }
}