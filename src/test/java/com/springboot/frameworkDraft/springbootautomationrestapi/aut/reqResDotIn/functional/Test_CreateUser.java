package com.springboot.frameworkDraft.springbootautomationrestapi.aut.reqResDotIn.functional;

import com.springboot.frameworkDraft.springbootautomationrestapi.aut.reqResDotIn.Base;
import com.springboot.frameworkDraft.springbootautomationrestapi.aut.reqResDotIn.source.helper.createUser.CreateUserHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.testng.annotations.Test;


public class Test_CreateUser extends Base {

    @Autowired
    public CreateUserHelper createUserHelper;

    @Test
    public void test_createUser(){
        createUserHelper.callAndValidateApi();
    }
}
