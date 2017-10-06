package com.example.hello.user.services;

import com.example.hello.user.models.UserData;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.inject.Inject;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionStage;

public class ExtractService {

    private final ExternalService externalService;

    @Inject
    public ExtractService(ExternalService externalService) {

        this.externalService = externalService;
    }

    public CompletionStage<Object> getUserData() {
        ObjectMapper format = new ObjectMapper();
        CompletionStage<Object> response = externalService.getUser().invoke();//"Lagom");
        return response.thenApply(answer -> {
            UserData userData = new UserData();//(1,1,"","");
            try {
                String x = format.writeValueAsString(answer);
                userData = format.readValue(x, UserData.class);

            } catch (Exception ex) {

            }
            return CompletableFuture.completedFuture(userData);
        });
    }
}
