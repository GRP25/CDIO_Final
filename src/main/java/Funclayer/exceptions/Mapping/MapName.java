package Funclayer.exceptions.Mapping;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import Funclayer.exceptions.ErrorMessage;
import Funclayer.exceptions.exceptions.NotANameException;

@Provider
public class MapName implements ExceptionMapper<NotANameException> {
    @Override
    public Response toResponse(NotANameException e) {
        ErrorMessage err = new ErrorMessage(e.getMessage(), 1103, "https://mama.sh/");
        return Response.status(Response.Status.NOT_ACCEPTABLE).entity(err).build();
    }
}