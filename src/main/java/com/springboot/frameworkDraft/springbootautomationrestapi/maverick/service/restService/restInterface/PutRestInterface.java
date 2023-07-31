package com.springboot.frameworkDraft.springbootautomationrestapi.maverick.service.restService.restInterface;

import com.fasterxml.jackson.databind.JsonNode;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import java.util.Map;

public interface PutRestInterface extends RestInterface{

    Response put(RequestSpecification rspec, String reqBody);
    Response put(RequestSpecification rspec, Object reqObject);
    Object put(RequestSpecification rspec, String reqPojo, Object resPojoObject);
    Object put(RequestSpecification rspec, Object reqPojoObject, Object resPojoObject);
    Map<String, Object> putAndReturnMap(RequestSpecification rspec, String reqBody);
    Map<String, Object> putAndReturnMap(RequestSpecification rspec, Object reqPojoObject);
    JsonNode putAndReturnNode(RequestSpecification rspec, String reqBody);
    JsonNode putAndReturnNode(RequestSpecification rspec, Object reqPojoObject);
}
