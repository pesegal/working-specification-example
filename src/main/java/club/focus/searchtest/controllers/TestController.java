package club.focus.searchtest.controllers;

import club.focus.searchtest.dto.PaginatedResultDto;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

@Path("/test")
public interface TestController {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public PaginatedResultDto testSearch(
            @DefaultValue("0") @QueryParam("page") int page,
            @DefaultValue("10") @QueryParam("size") int size,
            @DefaultValue("") @QueryParam("search") String searchText
    );

}
