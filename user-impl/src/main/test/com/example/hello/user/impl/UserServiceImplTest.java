package com.example.hello.user.impl;

import com.example.hello.user.api.UserService;
import com.example.hello.user.models.UserData;
import com.example.hello.user.services.ExternalService;
import com.example.hello.user.services.ExtractService;
import com.google.inject.Inject;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionStage;

import static com.lightbend.lagom.javadsl.testkit.ServiceTest.defaultSetup;
import static com.lightbend.lagom.javadsl.testkit.ServiceTest.withServer;
import static java.util.concurrent.TimeUnit.SECONDS;
import static org.junit.Assert.assertEquals;

/*
static class ExtractStub extends ExtractService {

    @Override
    public ServiceCall<NotUsed, Object> getUserData() {
        return req -> CompletableFuture.completedFuture("Hello");
    }

}
    private final Setup setup2 = defaultSetup().withCluster(true);

    private final ServiceTest.Setup setup = defaultSetup()
            .withConfigureBuilder(b -> b.overrides(
                    bind(ExtractService.class).to(ExtractStub.class)));


public class UserServiceImplTest {

    @Test
    public void shouldGetUserData() throws Exception {
        */
/*withServer(defaultSetup(), server -> {
            HelloService service = server.client(HelloService.class);

            String msg = service.sayHello().invoke("Alice").toCompletableFuture().get(5, SECONDS);
            assertEquals("Hello Alice", msg);
        });*//*


    }
}

public class HelloServiceTest {

    @Test
    public void shouldSayHello() throws Exception {
        withServer(defaultSetup(), server -> {
            HelloService service = server.client(HelloService.class);

            String msg = service.sayHello().invoke("Alice").toCompletableFuture().get(5, SECONDS);
            assertEquals("Hello Alice", msg);
        });
    }

}
*/
/*static class GreetingStub extends ExtractService {

}*/
/*
static class UserStub implements UserService {
    @Override
    public ServiceCall<NotUsed, Object> helloUser() {
        return req -> CompletableFuture.completedFuture(new Object());
    }
}
*/
//@RunWith(PowerMockRunner.class)

public class UserServiceImplTest extends Mockito{




   /* private final ServiceTest.Setup setup = defaultSetup()
            .withConfigureBuilder(b -> b.overrides(
                    bind(UserService.class).to(UserStub.class))).withCluster(true);*/
    //  private final ServiceTest.Setup setup2 = defaultSetup().withCluster(true);


    private ExternalService externalService;
/*
     private final ServiceTest.Setup setup = defaultSetup()
             .withConfigureBuilder(b -> b.overrides(
                     bind(ExtractService.class).to(ExtractStub.class)));*/
     @Test
    public void shouldGetUserData() throws Exception {

         ExtractService extractService = mock(ExtractService.class);


        withServer(defaultSetup(), server -> {

            final CompletionStage<Object> expectedResponse = CompletableFuture.supplyAsync(() -> {
                return "42";
            });
            when(extractService.getUserData()).thenReturn(expectedResponse);
            UserService service = server.client(UserService.class);
            System.out.println("\n\njasmine_______________________________________________"+expectedResponse);

            expectedResponse.thenAccept((a)->System.out.println(a));
            Object receivedResponse = service.helloUser().invoke().toCompletableFuture().get(5, SECONDS);
            System.out.println("jassu5");

            System.out.println("\n\njasmine "+expectedResponse);
            System.out.println("\n\njasminekaur "+receivedResponse);
            expectedResponse.thenAccept((expectedResult)->assertEquals(expectedResult,receivedResponse));
        });


    }

    static class ExtractStub extends ExtractService {
        @Inject
        ExtractStub(ExternalService externalService) {
            super(externalService);
        }

        @Override
        public CompletionStage<Object> getUserData() {
            UserData userData = new UserData();//(1,1,"","");

            return CompletableFuture.completedFuture(userData);
        }
    }
}

