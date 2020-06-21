package Funclayer.exceptions.Mapping;

import Funclayer.exceptions.ErrorMessage;
import Funclayer.exceptions.exceptions.IDException;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

@Provider
public class MapID implements ExceptionMapper<IDException> {
    @Override
    public Response toResponse(IDException e) {
        ErrorMessage errorMessage = new ErrorMessage( e.getMessage(), 11, "https://mama.sh/" );
        return Response.status(Response.Status.NOT_ACCEPTABLE).entity(errorMessage).build();

    }
}
