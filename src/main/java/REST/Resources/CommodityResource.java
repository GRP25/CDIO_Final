package REST.Resources;

import REST.Services.Implementation.CommodityService;
import REST.Services.Interfaces.ICommodityService;

import javax.ws.rs.Consumes;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;


@Path( "/commodity/" )
@Consumes( MediaType.APPLICATION_JSON )
@Produces( MediaType.APPLICATION_JSON )
public class CommodityResource {

    ICommodityService commodityService = new CommodityService();





}
