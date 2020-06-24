package Funclayer.exceptions.Mapping;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import Funclayer.exceptions.ErrorMessage;

import java.sql.SQLException;

@Provider
public class MapSQLException implements ExceptionMapper<SQLException> {

    @Override
    public Response toResponse(SQLException e) {
        ErrorMessage err = new ErrorMessage(e.getMessage(), 2100, "http://backup.mama.sh/cdio/api/");
        return Response.status(Response.Status.NOT_ACCEPTABLE).entity(err).build();
    }
}
