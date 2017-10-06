package com.example.hello.user.services;

import org.junit.Test;

import static com.lightbend.lagom.javadsl.testkit.ServiceTest.defaultSetup;
import static com.lightbend.lagom.javadsl.testkit.ServiceTest.withServer;

import static java.util.concurrent.TimeUnit.SECONDS;
import static org.junit.Assert.assertEquals;

public class ExtractServiceTest {
    /*@Test
    public void shouldSayHello() throws Exception {

        withServer(defaultSetup(), server -> {
            ExtractService service = server.client(ExtractService.class);

            String msg = service.getUserData().invoke().toCompletableFuture().get(5, SECONDS);
            assertEquals("Hello Alice", msg);
        });
    }*/

}
