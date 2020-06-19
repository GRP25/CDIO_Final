package Funclayer.exceptions.Mapping;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import Funclayer.exceptions.ErrorMessage;
import Funclayer.exceptions.exceptions.DataLayerException;

@Provider
public class MapDataLayer implements ExceptionMapper<DataLayerException> {
    @Override
    public Response toResponse(DataLayerException e) {
        ErrorMessage err = new ErrorMessage(e.getMessage(), 5, "https://mama.sh/");
        return Response.status(Response.Status.NOT_ACCEPTABLE).entity(err).build();
    }
}
