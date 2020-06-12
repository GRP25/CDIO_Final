package REST;

import Datalayer.DTO.UserDTO;
import Funclayer.UserService;
import Funclayer.IUserService;
import Funclayer.exceptions.UserException;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.ArrayList;
import java.util.List;

import static Funclayer.exceptions.Validation.validateUser;


@Path("userresource")
public class UserResource {
    IUserService userService = new UserService();

    @Path("/{userID}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public UserDTO getUser(@PathParam("userID") int userID) {

        return userService.getUser(userID);
    }

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public void updateUser(UserDTO user) throws UserException {
        validateUser(user);
        userService.updateUser(user);
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public void createUser(UserDTO user) throws UserException{
        validateUser(user);
        userService.createUser(user);
    }

    @Path("/{userID}")
    @DELETE
    public void deleteUser(@PathParam("userID") int userID) {
        userService.deleteUser(userID);
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<UserDTO> getUserList() {
        return userService.getUserList();
    }

}
