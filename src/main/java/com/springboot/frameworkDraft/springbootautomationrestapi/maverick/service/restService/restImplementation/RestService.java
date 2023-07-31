package com.springboot.frameworkDraft.springbootautomationrestapi.maverick.service.restService.restImplementation;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.springboot.frameworkDraft.springbootautomationrestapi.maverick.service.restService.restInterface.DeleteRestInterface;
import com.springboot.frameworkDraft.springbootautomationrestapi.maverick.service.restService.restInterface.GetRestInterface;
import com.springboot.frameworkDraft.springbootautomationrestapi.maverick.service.restService.restInterface.PostRestInterface;
import com.springboot.frameworkDraft.springbootautomationrestapi.maverick.service.restService.restInterface.PutRestInterface;
import io.restassured.RestAssured;
import io.restassured.config.EncoderConfig;
import io.restassured.config.SSLConfig;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import java.util.Map;

/**
 * @author manoj263.kumar
 */
public class RestService implements GetRestInterface, PostRestInterface, PutRestInterface, DeleteRestInterface {


    /**
     * @param rspec
     * @return
     */
    @Override
    public Response get(RequestSpecification rspec) {
        Response res =  RestAssured.given(rspec)
                .config(RestAssured.config().sslConfig(new SSLConfig().relaxedHTTPSValidation()).and().encoderConfig(EncoderConfig.encoderConfig().appendDefaultContentCharsetToContentTypeIfUndefined(false)))
                .get();
        return res;
    }

    /**
     * @param rspec
     * @param pojoObject
     * @return
     */
    @Override
    public Object get(RequestSpecification rspec, Object pojoObject) {
        Response res =  RestAssured.given(rspec)
                .config(RestAssured.config().sslConfig(new SSLConfig().relaxedHTTPSValidation()).and().encoderConfig(EncoderConfig.encoderConfig().appendDefaultContentCharsetToContentTypeIfUndefined(false)))
                .get();
        return convertToPojoObject(res, pojoObject);
    }


    /**
     * @param rspec
     * @return
     */
    @Override
    public Map<String, Object> getAndReturnMap(RequestSpecification rspec) {
        Response res =  RestAssured.given(rspec)
                .config(RestAssured.config().sslConfig(new SSLConfig().relaxedHTTPSValidation()).and().encoderConfig(EncoderConfig.encoderConfig().appendDefaultContentCharsetToContentTypeIfUndefined(false)))
                .get();
        return convertToMap(res);
    }

    /**
     * @param rspec
     * @return
     */
    @Override
    public JsonNode getAndReturnNode(RequestSpecification rspec) {
        Response res =  RestAssured.given(rspec)
                .config(RestAssured.config().sslConfig(new SSLConfig().relaxedHTTPSValidation()).and().encoderConfig(EncoderConfig.encoderConfig().appendDefaultContentCharsetToContentTypeIfUndefined(false)))
                .get();
        return convertToJsonNode(res);
    }

    /**
     * @param rspec
     * @param reqBody
     * @return
     */
    @Override
    public Response post(RequestSpecification rspec, String reqBody) {

        Response res =  RestAssured.given(rspec)
                .config(RestAssured.config().sslConfig(new SSLConfig().relaxedHTTPSValidation()).and().encoderConfig(EncoderConfig.encoderConfig().appendDefaultContentCharsetToContentTypeIfUndefined(false)))
                .body(reqBody)
                .post();
        return res;
    }

    /**
     * @param rspec
     * @param reqObject
     * @return
     */
    @Override
    public Response post(RequestSpecification rspec, Object reqObject) {
        Response res =  RestAssured.given(rspec)
                .config(RestAssured.config().sslConfig(new SSLConfig().relaxedHTTPSValidation()).and().encoderConfig(EncoderConfig.encoderConfig().appendDefaultContentCharsetToContentTypeIfUndefined(false)))
                .body(reqObject)
                .post();
        return res;
    }

    /**
     * @param rspec
     * @param reqBody
     * @param resPojoObject
     * @return
     */
    @Override
    public Object post(RequestSpecification rspec, String reqBody, Object resPojoObject) {
        Response res =  RestAssured.given(rspec)
                .config(RestAssured.config().sslConfig(new SSLConfig().relaxedHTTPSValidation()).and().encoderConfig(EncoderConfig.encoderConfig().appendDefaultContentCharsetToContentTypeIfUndefined(false)))
                .body(reqBody)
                .post();
        return convertToPojoObject(res, resPojoObject);
    }

    /**
     * @param rspec
     * @param reqPojoObject
     * @param resPojoObject
     * @return
     */
    @Override
    public Object post(RequestSpecification rspec, Object reqPojoObject, Object resPojoObject) {
        Response res =  RestAssured.given(rspec)
                .config(RestAssured.config().sslConfig(new SSLConfig().relaxedHTTPSValidation()).and().encoderConfig(EncoderConfig.encoderConfig().appendDefaultContentCharsetToContentTypeIfUndefined(false)))
                .body(reqPojoObject)
                .post();
        return convertToPojoObject(res, resPojoObject);
    }

    /**
     * @param rspec
     * @param reqBody
     * @return
     */
    @Override
    public Map<String, Object> postAndReturnMap(RequestSpecification rspec, String reqBody) {
        Response res =  RestAssured.given(rspec)
                .config(RestAssured.config().sslConfig(new SSLConfig().relaxedHTTPSValidation()).and().encoderConfig(EncoderConfig.encoderConfig().appendDefaultContentCharsetToContentTypeIfUndefined(false)))
                .body(reqBody)
                .post();
        return convertToMap(res);
    }

    /**
     * @param rspec
     * @param reqPojoObject
     * @return
     */
    @Override
    public Map<String, Object> postAndReturnMap(RequestSpecification rspec, Object reqPojoObject) {
        Response res =  RestAssured.given(rspec)
                .config(RestAssured.config().sslConfig(new SSLConfig().relaxedHTTPSValidation()).and().encoderConfig(EncoderConfig.encoderConfig().appendDefaultContentCharsetToContentTypeIfUndefined(false)))
                .body(reqPojoObject)
                .post();
        return convertToMap(res);
    }

    /**
     * @param rspec
     * @param reqBody
     * @return
     */
    @Override
    public JsonNode postAndReturnNode(RequestSpecification rspec, String reqBody) {
        Response res =  RestAssured.given(rspec)
                .config(RestAssured.config().sslConfig(new SSLConfig().relaxedHTTPSValidation()).and().encoderConfig(EncoderConfig.encoderConfig().appendDefaultContentCharsetToContentTypeIfUndefined(false)))
                .body(reqBody)
                .post();
        return convertToJsonNode(res);
    }

    /**
     * @param rspec
     * @param reqPojoObject
     * @return
     */
    @Override
    public JsonNode postAndReturnNode(RequestSpecification rspec, Object reqPojoObject) {
        Response res =  RestAssured.given(rspec)
                .config(RestAssured.config().sslConfig(new SSLConfig().relaxedHTTPSValidation()).and().encoderConfig(EncoderConfig.encoderConfig().appendDefaultContentCharsetToContentTypeIfUndefined(false)))
                .body(reqPojoObject)
                .post();
        return convertToJsonNode(res);
    }

    /**
     * @param rspec
     * @param reqBody
     * @return
     */
    @Override
    public Response put(RequestSpecification rspec, String reqBody) {

        Response res =  RestAssured.given(rspec)
                .config(RestAssured.config().sslConfig(new SSLConfig().relaxedHTTPSValidation()).and().encoderConfig(EncoderConfig.encoderConfig().appendDefaultContentCharsetToContentTypeIfUndefined(false)))
                .body(reqBody)
                .put();
        return res;
    }

    /**
     * @param rspec
     * @param reqObject
     * @return
     */
    @Override
    public Response put(RequestSpecification rspec, Object reqObject) {
        Response res =  RestAssured.given(rspec)
                .config(RestAssured.config().sslConfig(new SSLConfig().relaxedHTTPSValidation()).and().encoderConfig(EncoderConfig.encoderConfig().appendDefaultContentCharsetToContentTypeIfUndefined(false)))
                .body(reqObject)
                .put();
        return res;
    }

    /**
     * @param rspec
     * @param reqBody
     * @param resPojoObject
     * @return
     */
    @Override
    public Object put(RequestSpecification rspec, String reqBody, Object resPojoObject) {
        Response res =  RestAssured.given(rspec)
                .config(RestAssured.config().sslConfig(new SSLConfig().relaxedHTTPSValidation()).and().encoderConfig(EncoderConfig.encoderConfig().appendDefaultContentCharsetToContentTypeIfUndefined(false)))
                .body(reqBody)
                .put();
        return convertToPojoObject(res, resPojoObject);
    }

    /**
     * @param rspec
     * @param reqPojoObject
     * @param resPojoObject
     * @return
     */
    @Override
    public Object put(RequestSpecification rspec, Object reqPojoObject, Object resPojoObject) {
        Response res =  RestAssured.given(rspec)
                .config(RestAssured.config().sslConfig(new SSLConfig().relaxedHTTPSValidation()).and().encoderConfig(EncoderConfig.encoderConfig().appendDefaultContentCharsetToContentTypeIfUndefined(false)))
                .body(reqPojoObject)
                .put();
        return convertToPojoObject(res, resPojoObject);
    }

    /**
     * @param rspec
     * @param reqBody
     * @return
     */
    @Override
    public Map<String, Object> putAndReturnMap(RequestSpecification rspec, String reqBody) {
        Response res =  RestAssured.given(rspec)
                .config(RestAssured.config().sslConfig(new SSLConfig().relaxedHTTPSValidation()).and().encoderConfig(EncoderConfig.encoderConfig().appendDefaultContentCharsetToContentTypeIfUndefined(false)))
                .body(reqBody)
                .put();
        return convertToMap(res);
    }

    /**
     * @param rspec
     * @param reqPojoObject
     * @return
     */
    @Override
    public Map<String, Object> putAndReturnMap(RequestSpecification rspec, Object reqPojoObject) {
        Response res =  RestAssured.given(rspec)
                .config(RestAssured.config().sslConfig(new SSLConfig().relaxedHTTPSValidation()).and().encoderConfig(EncoderConfig.encoderConfig().appendDefaultContentCharsetToContentTypeIfUndefined(false)))
                .body(reqPojoObject)
                .put();
        return convertToMap(res);
    }

    /**
     * @param rspec
     * @param reqBody
     * @return
     */
    @Override
    public JsonNode putAndReturnNode(RequestSpecification rspec, String reqBody) {
        Response res =  RestAssured.given(rspec)
                .config(RestAssured.config().sslConfig(new SSLConfig().relaxedHTTPSValidation()).and().encoderConfig(EncoderConfig.encoderConfig().appendDefaultContentCharsetToContentTypeIfUndefined(false)))
                .body(reqBody)
                .put();
        return convertToJsonNode(res);
    }

    /**
     * @param rspec
     * @param reqPojoObject
     * @return
     */
    @Override
    public JsonNode putAndReturnNode(RequestSpecification rspec, Object reqPojoObject) {
        Response res =  RestAssured.given(rspec)
                .config(RestAssured.config().sslConfig(new SSLConfig().relaxedHTTPSValidation()).and().encoderConfig(EncoderConfig.encoderConfig().appendDefaultContentCharsetToContentTypeIfUndefined(false)))
                .body(reqPojoObject)
                .put();
        return convertToJsonNode(res);
    }

    /**
     * @param rspec
     * @param reqBody
     * @return
     */
    @Override
    public Response delete(RequestSpecification rspec, String reqBody) {

        Response res =  RestAssured.given(rspec)
                .config(RestAssured.config().sslConfig(new SSLConfig().relaxedHTTPSValidation()).and().encoderConfig(EncoderConfig.encoderConfig().appendDefaultContentCharsetToContentTypeIfUndefined(false)))
                .body(reqBody)
                .delete();
        return res;
    }

    /**
     * @param rspec
     * @param reqObject
     * @return
     */
    @Override
    public Response delete(RequestSpecification rspec, Object reqObject) {
        Response res =  RestAssured.given(rspec)
                .config(RestAssured.config().sslConfig(new SSLConfig().relaxedHTTPSValidation()).and().encoderConfig(EncoderConfig.encoderConfig().appendDefaultContentCharsetToContentTypeIfUndefined(false)))
                .body(reqObject)
                .delete();
        return res;
    }

    /**
     * @param rspec
     * @param reqBody
     * @param resPojoObject
     * @return
     */
    @Override
    public Object delete(RequestSpecification rspec, String reqBody, Object resPojoObject) {
        Response res =  RestAssured.given(rspec)
                .config(RestAssured.config().sslConfig(new SSLConfig().relaxedHTTPSValidation()).and().encoderConfig(EncoderConfig.encoderConfig().appendDefaultContentCharsetToContentTypeIfUndefined(false)))
                .body(reqBody)
                .delete();
        return convertToPojoObject(res, resPojoObject);
    }

    /**
     * @param rspec
     * @param reqPojoObject
     * @param resPojoObject
     * @return
     */
    @Override
    public Object delete(RequestSpecification rspec, Object reqPojoObject, Object resPojoObject) {
        Response res =  RestAssured.given(rspec)
                .config(RestAssured.config().sslConfig(new SSLConfig().relaxedHTTPSValidation()).and().encoderConfig(EncoderConfig.encoderConfig().appendDefaultContentCharsetToContentTypeIfUndefined(false)))
                .body(reqPojoObject)
                .delete();
        return convertToPojoObject(res, resPojoObject);
    }

    /**
     * @param rspec
     * @param reqBody
     * @return
     */
    @Override
    public Map<String, Object> deleteAndReturnMap(RequestSpecification rspec, String reqBody) {
        Response res =  RestAssured.given(rspec)
                .config(RestAssured.config().sslConfig(new SSLConfig().relaxedHTTPSValidation()).and().encoderConfig(EncoderConfig.encoderConfig().appendDefaultContentCharsetToContentTypeIfUndefined(false)))
                .body(reqBody)
                .delete();
        return convertToMap(res);
    }

    /**
     * @param rspec
     * @param reqPojoObject
     * @return
     */
    @Override
    public Map<String, Object> deleteAndReturnMap(RequestSpecification rspec, Object reqPojoObject) {
        Response res =  RestAssured.given(rspec)
                .config(RestAssured.config().sslConfig(new SSLConfig().relaxedHTTPSValidation()).and().encoderConfig(EncoderConfig.encoderConfig().appendDefaultContentCharsetToContentTypeIfUndefined(false)))
                .body(reqPojoObject)
                .delete();
        return convertToMap(res);
    }

    /**
     * @param rspec
     * @param reqBody
     * @return
     */
    @Override
    public JsonNode deleteAndReturnNode(RequestSpecification rspec, String reqBody) {
        Response res =  RestAssured.given(rspec)
                .config(RestAssured.config().sslConfig(new SSLConfig().relaxedHTTPSValidation()).and().encoderConfig(EncoderConfig.encoderConfig().appendDefaultContentCharsetToContentTypeIfUndefined(false)))
                .body(reqBody)
                .delete();
        return convertToJsonNode(res);
    }

    /**
     * @param rspec
     * @param reqPojoObject
     * @return
     */
    @Override
    public JsonNode deleteAndReturnNode(RequestSpecification rspec, Object reqPojoObject) {
        Response res =  RestAssured.given(rspec)
                .config(RestAssured.config().sslConfig(new SSLConfig().relaxedHTTPSValidation()).and().encoderConfig(EncoderConfig.encoderConfig().appendDefaultContentCharsetToContentTypeIfUndefined(false)))
                .body(reqPojoObject)
                .delete();
        return convertToJsonNode(res);
    }

    private Object convertToPojoObject(Response res, Object pojoObject) {
        ObjectMapper mapper = new ObjectMapper();
        try {
            return mapper.readValue(res.asString(), pojoObject.getClass());
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

    private Map<String, Object> convertToMap(Response res) {
        ObjectMapper mapper = new ObjectMapper();
        try {
            return mapper.readValue(res.asString(), new TypeReference<>(){});
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

    private JsonNode convertToJsonNode(Response res) {
        ObjectMapper mapper = new ObjectMapper();
        try {
            return mapper.readTree(res.asString());
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }
}
