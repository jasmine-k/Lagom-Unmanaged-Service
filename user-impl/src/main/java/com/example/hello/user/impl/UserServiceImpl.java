package com.example.hello.user.impl;

import akka.NotUsed;
import com.example.hello.user.api.UserService;
import com.example.hello.user.services.ExtractService;
import com.google.inject.Inject;
import com.lightbend.lagom.javadsl.api.ServiceCall;
import java.util.concurrent.CompletableFuture;


public class UserServiceImpl implements UserService {

    private final ExtractService extractService;

    @Inject
    UserServiceImpl(ExtractService extractService) {
        this.extractService = extractService;
    }

    @Override
    public ServiceCall<NotUsed, Object> helloUser() {
        return request ->
                extractService.getUserData();
    }

}
