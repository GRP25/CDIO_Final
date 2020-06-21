package Funclayer.exceptions.Mapping;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import Funclayer.exceptions.ErrorMessage;
import Funclayer.exceptions.exceptions.NotACPRException;

@Provider
public class MapCPR implements ExceptionMapper<NotACPRException> {
  @Override
  public Response toResponse(NotACPRException e) {
    ErrorMessage err = new ErrorMessage(e.getMessage(), 2, "https://mama.sh/");
    return Response.status(Response.Status.NOT_ACCEPTABLE).entity(err).build();
  }
}
