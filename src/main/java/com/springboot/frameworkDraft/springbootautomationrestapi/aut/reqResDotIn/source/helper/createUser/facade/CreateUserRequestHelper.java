package com.springboot.frameworkDraft.springbootautomationrestapi.aut.reqResDotIn.source.helper.createUser.facade;

import com.github.javafaker.Faker;
import com.springboot.frameworkDraft.springbootautomationrestapi.aut.reqResDotIn.source.dto.createUser.CreateUserRequestDto;
import com.springboot.frameworkDraft.springbootautomationrestapi.aut.reqResDotIn.source.dto.createUser.CreateUserResponseDto;
import com.springboot.frameworkDraft.springbootautomationrestapi.aut.reqResDotIn.source.helper.sourceBase.SourceBase;
import com.springboot.frameworkDraft.springbootautomationrestapi.maverick.service.config.ConfigService;
import com.springboot.frameworkDraft.springbootautomationrestapi.maverick.service.restService.restImplementation.RestService;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

public class CreateUserRequestHelper extends SourceBase {

    private RequestSpecification requestBuilder(){
        RequestSpecBuilder requestSpecBuilder = new RequestSpecBuilder();
        requestSpecBuilder.setBaseUri("https://reqres.in/");
        requestSpecBuilder.setBasePath("api/users");
        requestSpecBuilder.setContentType(ContentType.JSON);
        return requestSpecBuilder.build();
    }
    private CreateUserRequestDto createRequestBody(){

        CreateUserRequestDto createUserRequestDto = new CreateUserRequestDto();
        createUserRequestDto.setJob("engineer");
        Faker faker = new Faker();
        createUserRequestDto.setName(faker.funnyName().name());

        return createUserRequestDto;
    }

    public CreateUserResponseDto callApi(){
        CreateUserRequestDto createUserRequestDto  = createRequestBody();
        RequestSpecification rspec = requestBuilder();

        RestService restService = new RestService();
        return (CreateUserResponseDto) restService.post(rspec, createUserRequestDto, new CreateUserResponseDto());
    }
}
