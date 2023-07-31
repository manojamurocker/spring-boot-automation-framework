package com.springboot.frameworkDraft.springbootautomationrestapi.aut.reqResDotIn.source.helper.createUser;

import com.springboot.frameworkDraft.springbootautomationrestapi.aut.reqResDotIn.source.dto.createUser.CreateUserResponseDto;
import org.testng.Assert;

public class CreateUserResponseHelper {

    CreateUserResponseDto createUserResponseDto;
    public void validateResponse(CreateUserResponseDto createUserResponseDto){
        this.createUserResponseDto = createUserResponseDto;
        verifyResponse();
    }

    private void verifyResponse(){
        Assert.assertNotNull(createUserResponseDto.getName());
        System.out.println(createUserResponseDto.getName());
    }
}
