package REST.Resources;

import Funclayer.implementation.DatabaseService;
import REST.SuccessMessage;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.sql.SQLException;

import static Funclayer.exceptions.validation.UserValidation.validateUserId;

@Path("db")
public class DBRecource {
    DatabaseService db = new DatabaseService();

    @Path("backup")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response activateUser(@PathParam("userID") int userID) throws SQLException {
        SuccessMessage msg = new SuccessMessage("Database succesfully changed", 1001, "https://mama.sh/");
        db.change();
        return Response.status(Response.Status.OK).entity(msg).build();
    }
}
