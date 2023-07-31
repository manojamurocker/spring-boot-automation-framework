package com.springboot.frameworkDraft.springbootautomationrestapi.maverick.service.restService.restInterface;

import com.fasterxml.jackson.databind.JsonNode;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import java.util.Map;

public interface GetRestInterface extends RestInterface {

    Response get(RequestSpecification rspec);
    Object get(RequestSpecification rspec, Object pojoObject);
    Map<String, Object> getAndReturnMap(RequestSpecification rspec);
    JsonNode getAndReturnNode(RequestSpecification rspec);
}
