package Funclayer.exceptions;


import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;
import java.sql.SQLException;

@Provider
public class MapDataLayer implements ExceptionMapper<SQLException> {
    @Override
    public Response toResponse(SQLException e) {
        ErrorMessage err = new ErrorMessage(e.getMessage(),5,"https://mama.sh/");
        return Response.status(Response.Status.NOT_ACCEPTABLE).entity(err).build();
    }
}
