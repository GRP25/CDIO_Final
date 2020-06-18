package Funclayer.exceptions.Mapping;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import Funclayer.exceptions.ErrorMessage;
import Funclayer.exceptions.exceptions.MAPSQLException;

@Provider
public class MapSQLException implements ExceptionMapper<MAPSQLException> {

    @Override
    public Response toResponse(MAPSQLException e) {
        ErrorMessage err = new ErrorMessage(e.getMessage(), 6, "https://mama.sh/");
        return Response.status(Response.Status.NOT_ACCEPTABLE).entity(err).build();
    }
}
