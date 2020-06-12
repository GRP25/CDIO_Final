package REST.Resources;

import Datalayer.DTO.UserDTO;
import Funclayer.implementation.UserService;
import Funclayer.interfaces.IUserService;
import Funclayer.exceptions.UserException;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.sql.SQLException;

import static Funclayer.exceptions.Validation.validateUser;


@Path("userresource")
public class UserResource {
    IUserService userService = new UserService();

    @Path("/{userID}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getUser(@PathParam("userID") int userID) throws SQLException {
        return Response.status(Response.Status.OK).entity(userService.getUser(userID)).build();
    }

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public Response updateUser(UserDTO user) throws UserException, SQLException {
        validateUser(user);
        userService.updateUser(user);
        return Response.status(Response.Status.OK).build();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response createUser(UserDTO user) throws UserException, SQLException{
        validateUser(user);
        userService.createUser(user);
        return Response.status(Response.Status.OK).build();
    }

    @Path("/{userID}")
    @DELETE
    public Response deleteUser(@PathParam("userID") int userID) throws SQLException {
        userService.deleteUser(userID);
        return Response.status(Response.Status.OK).build();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getUserList() throws SQLException {
        return Response.status(Response.Status.OK).entity(userService.getUserList()).build();
    }

}
