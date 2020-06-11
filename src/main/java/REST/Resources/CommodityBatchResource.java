package REST.Resources;

import Datalayer.DAO.DALException;
import Datalayer.DTO.CommodityBatchDTO;
import REST.Services.Implementation.CommodityBatchService;
import REST.Services.Interfaces.ICommodityBatchService;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;


import java.util.List;

@Path( "/commodityBatch/" )
public class CommodityBatchResource {

    ICommodityBatchService commodityBatchService = new CommodityBatchService();

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getCommodityBatchList() throws DALException {
        Response response;
        List<CommodityBatchDTO> commodityBatchDTOList = commodityBatchService.getCommodityBatchList();

        if (commodityBatchDTOList != null)
            response = Response.status( Response.Status.OK ).entity( commodityBatchDTOList ).build();
        else
            response = Response.status( Response.Status.BAD_REQUEST ).entity( "Expstion: from CommodityBatchResource.getCommodityBatchList" ).build();

        return response;
    }

}
