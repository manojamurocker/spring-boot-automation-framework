package com.springboot.frameworkDraft.springbootautomationrestapi.aut.reqResDotIn.tests.functional.createUser;

import com.github.javafaker.Faker;
import com.springboot.frameworkDraft.springbootautomationrestapi.aut.reqResDotIn.source.helper.createUser.CreateUserHelper;
import com.springboot.frameworkDraft.springbootautomationrestapi.aut.reqResDotIn.tests.functional.base.TestBase;
import com.springboot.frameworkDraft.springbootautomationrestapi.maverick.service.assertion.AssertionService;
import com.springboot.frameworkDraft.springbootautomationrestapi.maverick.service.config.ConfigService;
import com.springboot.frameworkDraft.springbootautomationrestapi.maverick.service.logger.LogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.testng.annotations.Test;

public class Test_CreateUser {

    @Autowired
    public ConfigService<Object> configService;
    @Test
    public void test_createUser(){
        Faker faker = new Faker();
        String name = faker.name().firstName();
        LogService.Assertion("Current Thread Id:" + Thread.currentThread().getId()+":"+name);
        this.configService.setProperty("ThreadIdName", Thread.currentThread().getId()+":"+name);

        this.configService.setProperty("UserType", "wholesalestore123");
//        CreateUserHelper createUserHelper = new CreateUserHelper(configService);
//        createUserHelper.callAndValidateApi();
    }
}
