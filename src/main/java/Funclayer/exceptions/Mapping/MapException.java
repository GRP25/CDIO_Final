package Funclayer.exceptions.Mapping;

import Funclayer.exceptions.ErrorMessage;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;
import java.sql.SQLException;

@Provider
public class MapException implements ExceptionMapper<Exception> {

    @Override
    public Response toResponse(Exception e) {
        ErrorMessage err = new ErrorMessage(e.getMessage(), 1100, "https://mama.sh/");
        return Response.status(Response.Status.NOT_ACCEPTABLE).entity(err).build();
    }
}
