package com.example.demo.integration.suite;

import com.example.demo.integration.util.DemoClient;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.*;

import javax.ws.rs.core.Response;
import java.lang.reflect.Method;

@Test(groups = "acceptance")
public class EndpointsTest {
    private final long startTime = System.currentTimeMillis();
    private DemoClient demoClient = new DemoClient();

    @BeforeClass
    public void setupOrgMatching() {
        System.out.printf("Starting %s...\n", this.getClass().getSimpleName());
    }

    @BeforeMethod(alwaysRun = true)
    public void beforeMethod(Method method) {
        System.out.println("Begin " + method.getName() + "...");
    }

    @AfterMethod(alwaysRun = true)
    public void afterMethod(ITestResult result) {
        System.out.println("End " + result.getMethod().getMethodName());
    }

    @AfterClass(alwaysRun = true)
    public void cleanup() {
        System.out.printf("Finished %s in %s ms\n", this.getClass().getSimpleName(), (System.currentTimeMillis() - startTime));
    }

    @Test
    public void testGetHeartbeat() {
        Response response = demoClient.heartbeat();

        Assert.assertEquals(response.getStatus(), 204);
    }

    @Test(groups = "fragile")
    public void testGetHeartbeatSkipped() {
        System.out.print("Executed a test that should be skipped");
    }
}
