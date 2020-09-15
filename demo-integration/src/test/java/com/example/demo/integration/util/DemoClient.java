package com.example.demo.integration.util;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.AnnotationIntrospector;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.introspect.JacksonAnnotationIntrospector;
import com.fasterxml.jackson.databind.type.TypeFactory;
import com.fasterxml.jackson.module.jaxb.JaxbAnnotationIntrospector;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.io.IOException;
import java.io.InputStream;
import java.util.Collection;
import java.util.Map;
import java.util.Properties;

public class DemoClient {
    private String demoHost;

    public DemoClient() {
        InputStream demoStream;
        Properties demoConfig = new Properties();

        try {
            demoStream = getClass().getClassLoader().getResourceAsStream("demo-integration.properties");
            demoConfig.load(demoStream);

            this.demoHost = demoConfig.getProperty("demoWebServer");
            if (demoStream != null) {
                demoStream.close();
            }
        } catch (IOException e) {
            System.out.println("Failed to load Demo properties");
            e.printStackTrace();
        }

    }

    private Response get(String path) {
        Client client = ClientBuilder.newClient();

        return client
                .target(demoHost)
                .path(path)
                .request(MediaType.APPLICATION_JSON)
                .get(Response.class);
    }

    private <T> Response post(String path, Map<String, String> params, T payload) {
        Client client = ClientBuilder.newClient();

        WebTarget target = client.target(demoHost);

        if (!params.isEmpty()) {
            for (String key : params.keySet()) {
                target = target.queryParam(key, params.get(key));
            }
        }

        return target.path(path)
                .request(MediaType.APPLICATION_JSON)
                .post(Entity.entity(payload, MediaType.APPLICATION_JSON));
    }

    public Response heartbeat() {
        Response response = get("/health");
        return response;
    }

    public Response heartbeatPost() {
        Response response = post("/health", null, null);

        return response;
    }
}
