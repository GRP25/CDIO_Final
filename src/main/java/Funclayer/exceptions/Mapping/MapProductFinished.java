package Funclayer.exceptions.Mapping;

import Funclayer.exceptions.ErrorMessage;
import Funclayer.exceptions.exceptions.ObjectException;
import Funclayer.exceptions.exceptions.ProductFinishedException;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

@Provider
public class MapProductFinished implements ExceptionMapper<ProductFinishedException> {

    @Override
    public Response toResponse(ProductFinishedException e) {
        ErrorMessage errorMessage = new ErrorMessage( e.getMessage(), 6101, "https://mama.sh/" );
        return Response.status(Response.Status.NOT_ACCEPTABLE).entity(errorMessage).build();
    }
}
