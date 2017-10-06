package com.example.hello.user.impl;

import com.example.hello.user.api.UserService;
import com.example.hello.user.services.ExternalService;
import com.google.inject.AbstractModule;
import com.lightbend.lagom.javadsl.server.ServiceGuiceSupport;

public class UserModule extends AbstractModule implements ServiceGuiceSupport {
    @Override
    protected void configure() {
        bindService(UserService.class, UserServiceImpl.class);
        bindClient(ExternalService.class);
    }

}
