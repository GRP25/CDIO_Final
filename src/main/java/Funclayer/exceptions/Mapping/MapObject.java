package Funclayer.exceptions.Mapping;

import Funclayer.exceptions.ErrorMessage;
import Funclayer.exceptions.exceptions.ObjectException;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

@Provider
public class MapObject implements ExceptionMapper<ObjectException> {

    @Override
    public Response toResponse(ObjectException e) {
        ErrorMessage errorMessage = new ErrorMessage( e.getMessage(), 12, "https://mama.sh/" );
        return Response.status(Response.Status.NOT_ACCEPTABLE).entity(errorMessage).build();
    }
}
