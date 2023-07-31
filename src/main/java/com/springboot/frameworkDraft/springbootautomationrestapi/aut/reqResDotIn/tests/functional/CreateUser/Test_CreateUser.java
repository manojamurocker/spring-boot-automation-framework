package com.springboot.frameworkDraft.springbootautomationrestapi.aut.reqResDotIn.tests.functional.CreateUser;

import com.springboot.frameworkDraft.springbootautomationrestapi.aut.reqResDotIn.source.helper.createUser.CreateUserHelper;
import org.testng.annotations.Test;

public class Test_CreateUser {

    @Test
    public void test_createUser(){
        CreateUserHelper createUserHelper = new CreateUserHelper();
        createUserHelper.callAndValidateApi();
    }
}
