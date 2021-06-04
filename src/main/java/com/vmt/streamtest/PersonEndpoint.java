package com.vmt.streamtest;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/hello1")
@ApplicationScoped
public class PersonEndpoint {
    @Inject
    PersonService personService;

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String helloWorld() {
        return "Hello World!";
    }

    @GET
    @Path("/stream")
    public Response streamExample() {
        return Response.ok(personService).build();
    }
}
