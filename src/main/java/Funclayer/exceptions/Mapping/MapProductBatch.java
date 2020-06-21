package Funclayer.exceptions.Mapping;

import Funclayer.exceptions.ErrorMessage;
import Funclayer.exceptions.exceptions.NotProductBatchExeption;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

@Provider
public class MapProductBatch implements ExceptionMapper<NotProductBatchExeption> {
    @Override
    public Response toResponse(NotProductBatchExeption e) {
        ErrorMessage err = new ErrorMessage(e.getMessage(), 13, "https://mama.sh/");
        return Response.status(Response.Status.NOT_ACCEPTABLE).entity(err).build();
    }


}
