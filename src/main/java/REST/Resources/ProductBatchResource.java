package REST.Resources;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

import Datalayer.DAO.ProductBatchCompDAO;
import Datalayer.DAO.ProductBatchDAO;
import Datalayer.DTO.ProductBatchCompDTO;
import Datalayer.DTO.ProductBatchDTO;
import Datalayer.Interfaces.IProductBatchCompDAO;
import Datalayer.Interfaces.IProductBatchDAO;

/*
* Get productbatch
* Post productbatch
*
* Get productbatch compound
* Post productbatch compound
*/

@Path("ProductBatchs")
public class ProductBatchResource {
    IProductBatchDAO productDAO = new ProductBatchDAO();
    IProductBatchCompDAO productCompDAO = new ProductBatchCompDAO();


    // create produkt batch
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public void createProductBatch(ProductBatchDTO productDTO) throws SQLException {
        productDAO.createProductBatch(productDTO);
    }

    // get all product batches
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<ProductBatchDTO> getAllProducts() throws SQLException {
        return productDAO.getProductBatchDTOList();
    }

    // get specific product batch
    @Path("/ID/{ProductID}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public ProductBatchDTO getProductBatchByID(@PathParam("ProductID") int productID) throws SQLException {
        return productDAO.getProductBatchDTO(productID);
    }


    // add product batch compount
    @Path("/Comp")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public void addProductComp(ProductBatchCompDTO pCompDTO) throws SQLException {
        productCompDAO.createProductBatchComp(pCompDTO);
    }

    // add get product compount
    @Path("/Comp/{ProductID}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<ProductBatchCompDTO>  getCompountsForProduct(@PathParam("ProductID") int productID) throws SQLException {
        return productCompDAO.getProductBatchCompList(productID);
    }
}