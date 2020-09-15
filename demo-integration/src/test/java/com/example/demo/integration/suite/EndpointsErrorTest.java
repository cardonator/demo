package com.example.demo.integration.suite;

import com.example.demo.integration.util.DemoClient;
import org.testng.Assert;
import org.testng.annotations.Test;

import javax.ws.rs.core.Response;

public class EndpointsErrorTest {
    private DemoClient demoClient = new DemoClient();

    @Test
    public void testGetHeartbeat() {
        Response response = demoClient.heartbeatPost();

        Assert.assertEquals(response.getStatus(), 405);
    }
}
