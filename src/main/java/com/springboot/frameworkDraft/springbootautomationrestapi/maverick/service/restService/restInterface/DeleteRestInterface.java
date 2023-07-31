package com.springboot.frameworkDraft.springbootautomationrestapi.maverick.service.restService.restInterface;

import com.fasterxml.jackson.databind.JsonNode;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import java.util.Map;

public interface DeleteRestInterface extends RestInterface {

    Response delete(RequestSpecification rspec, String reqBody);
    Response delete(RequestSpecification rspec, Object reqObject);
    Object delete(RequestSpecification rspec, String reqPojo, Object resPojoObject);
    Object delete(RequestSpecification rspec, Object reqPojoObject, Object resPojoObject);
    Map<String, Object> deleteAndReturnMap(RequestSpecification rspec, String reqBody);
    Map<String, Object> deleteAndReturnMap(RequestSpecification rspec, Object reqPojoObject);
    JsonNode deleteAndReturnNode(RequestSpecification rspec, String reqBody);
    JsonNode deleteAndReturnNode(RequestSpecification rspec, Object reqPojoObject);
}
