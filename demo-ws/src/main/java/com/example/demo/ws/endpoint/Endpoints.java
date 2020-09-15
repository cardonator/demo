package com.example.demo.ws.endpoint;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;


@Component
@Path("/")
public class Endpoints {

    Logger logger = LoggerFactory.getLogger(Endpoints.class);

    @GET
    @Path("health")
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public Response getHeartBeat() {
        return Response.noContent().build();
    }
}
