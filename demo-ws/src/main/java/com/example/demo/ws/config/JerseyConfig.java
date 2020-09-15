package com.example.demo.ws.config;

import com.example.demo.ws.endpoint.Endpoints;
import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.context.annotation.Configuration;

@Configuration
public class JerseyConfig extends ResourceConfig {
    public JerseyConfig() {
        register(Endpoints.class);
    }
}
