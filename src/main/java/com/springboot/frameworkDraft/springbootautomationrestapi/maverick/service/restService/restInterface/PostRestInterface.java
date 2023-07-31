package com.springboot.frameworkDraft.springbootautomationrestapi.maverick.service.restService.restInterface;

import com.fasterxml.jackson.databind.JsonNode;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import java.util.Map;

public interface PostRestInterface extends RestInterface {

    Response post(RequestSpecification rspec, String reqBody);
    Response post(RequestSpecification rspec, Object reqObject);
    Object post(RequestSpecification rspec, String reqPojo, Object resPojoObject);
    Object post(RequestSpecification rspec, Object reqPojoObject, Object resPojoObject);
    Map<String, Object> postAndReturnMap(RequestSpecification rspec, String reqBody);
    Map<String, Object> postAndReturnMap(RequestSpecification rspec, Object reqPojoObject);
    JsonNode postAndReturnNode(RequestSpecification rspec, String reqBody);
    JsonNode postAndReturnNode(RequestSpecification rspec, Object reqPojoObject);
}
