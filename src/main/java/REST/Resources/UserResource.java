package REST.Resources;

import Datalayer.DTO.UserDTO;
import Funclayer.exceptions.exceptions.UserException;
import Funclayer.implementation.UserService;
import Funclayer.interfaces.IUserService;
import REST.SuccessMessage;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.sql.SQLException;

import static Funclayer.exceptions.validation.UserValidation.validateUserId;


@Path("userresource")
public class UserResource {
    IUserService userService = new UserService();

    @Path("/{userID}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getUser(@PathParam("userID") int userID) throws SQLException{
        validateUserId(userID);
        UserDTO response = userService.getUser(userID);
        return Response.status(Response.Status.OK).entity(response).build();
    }

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response updateUser(UserDTO user) throws UserException, SQLException {
        userService.updateUser(user);
        SuccessMessage msg = new SuccessMessage("Updated", 1, "https://mama.sh/doc");
        return Response.status(Response.Status.OK).entity(msg).build();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response createUser(UserDTO user) throws UserException, SQLException{
        userService.createUser(user);
        SuccessMessage msg = new SuccessMessage("Created", 2, "https://mama.sh/doc");
        return Response.status(Response.Status.OK).entity(msg).build();
    }

    @DELETE
    @Path("/{userID}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response deleteUser(@PathParam("userID") int userID) throws SQLException {
        userService.deleteUser(userID);
        SuccessMessage msg = new SuccessMessage("Deleted", 3, "https://mama.sh/doc");
        return Response.status(Response.Status.OK).entity(msg).build();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getUserList() throws SQLException {
        return Response.status(Response.Status.OK).entity(userService.getUserList()).build();
    }
}
