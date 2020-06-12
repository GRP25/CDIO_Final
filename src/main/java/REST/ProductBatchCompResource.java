package REST;

import Datalayer.DAO.ProductBatchCompDAO;
import Datalayer.DTO.ProductBatchCompDTO;
import Datalayer.Interfaces.IProductBatchCompDAO;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

public class ProductBatchCompResource {
    IProductBatchCompDAO productBatchCompDAO = new ProductBatchCompDAO();

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public void createProductBatchComp(ProductBatchCompDTO productBatchCompDTO){
        productBatchCompDAO.createProductBatchComp(productBatchCompDTO);
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<ProductBatchCompDTO> getAllProductBatchCompList(){
        return productBatchCompDAO.getProductBatchCompList();
    }

    @Path("/ID/{ProductID}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<ProductBatchCompDTO> getProductBatchCompListByID(@PathParam("ProductID") int productBatch_id){
        return productBatchCompDAO.getProductBatchCompList(productBatch_id);
    }


}
