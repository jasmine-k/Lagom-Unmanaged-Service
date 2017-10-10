/*
package com.example.hello.user.services;

import akka.NotUsed;
import com.lightbend.lagom.javadsl.api.ServiceCall;
import com.lightbend.lagom.javadsl.testkit.ServiceTest;
import mockit.Injectable;
import mockit.Mock;
import mockit.MockUp;
import org.junit.Test;

import javax.inject.Inject;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionStage;

import static com.lightbend.lagom.javadsl.testkit.ServiceTest.defaultSetup;
import static com.lightbend.lagom.javadsl.testkit.ServiceTest.withServer;
import static java.util.concurrent.TimeUnit.SECONDS;
import static org.junit.Assert.assertEquals;
import static play.inject.Bindings.bind;
import play.inject.guice.GuiceApplicationBuilder;

public class ExtractServiceTest {
    static class ExternalStub implements ExternalService {
        @Override
        public ServiceCall<NotUsed, Object> getUser() {
            return request -> CompletableFuture.completedFuture("Unmanaged service");
        }
    }

    @Test
    public void testGetUserData() throws Exception {
        CompletionStage<Object> expectedResponse = CompletableFuture.supplyAsync(() -> {
            return "un-managed service";
        });
        */
/*new MockUp<ExtractService>() {
            @Inject
            @Mock
            public void $init(ExternalService externalService) {
            }
        };*//*

        */
/*new MockUp<ExternalService>() {
            @SuppressWarnings("unused")
            @Mock
            public CompletionStage<Object> getUserData() {
                return expectedResult;
            }
        };*//*


        ExtractService extractService = new GuiceApplicationBuilder()
                .overrides(bind(ExternalService.class).to(ExternalStub.class))
                .build();
        Object receivedResponse = extractService.getUserData().toCompletableFuture().get(5, SECONDS);
        expectedResponse.thenAccept((expectedResult) -> assertEquals(expectedResult, receivedResponse));

    }

    */
/*@Test
    public void shouldSayHello() throws Exception {

        withServer(defaultSetup(), server -> {
            ExtractService service = server.client(ExtractService.class);

            String msg = service.getUserData().invoke().toCompletableFuture().get(5, SECONDS);
            assertEquals("Hello Alice", msg);
        });
    }*//*



}
*/
