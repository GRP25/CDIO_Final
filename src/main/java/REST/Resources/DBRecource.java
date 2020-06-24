package REST.Resources;

import Funclayer.implementation.DatabaseService;
import REST.SuccessMessage;
import org.mariadb.jdbc.internal.com.read.resultset.SelectResultSet;

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
    public Response activateUser() {
        SuccessMessage msg = new SuccessMessage("Database succesfully changed", 1001, "http://backup.mama.sh/cdio/api/");
        db.change();
        return Response.status(Response.Status.OK).entity(msg).build();
    }
    @Path("check")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response check() {
        SuccessMessage msg;
        if (db.checkIfDBisMain())
            msg = new SuccessMessage("Database is main", 1002, "http://backup.mama.sh/cdio/api/");
        else
            msg = new SuccessMessage("Database is backup", 1003, "http://backup.mama.sh/cdio/api/");
        return Response.status(Response.Status.OK).entity(msg).build();
    }
}
