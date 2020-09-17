package com.example.demo.ws.endpoint;


import com.example.demo.ws.model.Organization;
import com.example.demo.ws.model.OrganizationIdList;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;


@Component
@Path("/")
public class Endpoints {

    Logger logger = LoggerFactory.getLogger(Endpoints.class);

    @Autowired
    public Endpoints() {}

    @GET
    @Path("health")
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public Response getHeartBeat() {
        return Response.noContent().build();
    }

//    @GET
//    @Path("orgids")
//    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
//    public Response getOrgIds() {
//        OrganizationIdList organizationIdList = new OrganizationIdList(List.of("1234567890"));
//
//        return Response.ok(organizationIdList).build();
//    }

}
