package com.example.hello.user.impl;

import com.example.hello.user.api.UserService;
import com.example.hello.user.services.ExtractService;
import mockit.Mock;
import mockit.MockUp;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionStage;

import static com.lightbend.lagom.javadsl.testkit.ServiceTest.defaultSetup;
import static com.lightbend.lagom.javadsl.testkit.ServiceTest.withServer;
import static java.util.concurrent.TimeUnit.SECONDS;
import static org.junit.Assert.assertEquals;

public class UserServiceImplTest extends Mockito {

    @Test
    public void shouldGetUserData() throws Exception {

        final CompletionStage<Object> expectedResponse = CompletableFuture.supplyAsync(() -> {
            return "Un-managed Service Data";
        });
        new MockUp<ExtractService>() {
            @SuppressWarnings("unused")
            @Mock
            public CompletionStage<Object> getUserData() {
                return expectedResponse;
            }
        };

        withServer(defaultSetup(), server -> {

            UserService service = server.client(UserService.class);
            Object receivedResponse = service.helloUser().invoke().toCompletableFuture().get(5, SECONDS);
            expectedResponse.thenAccept((expectedResult) -> assertEquals(expectedResult, receivedResponse));
        });
    }
}

