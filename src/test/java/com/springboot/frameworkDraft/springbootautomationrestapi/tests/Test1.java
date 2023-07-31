package com.springboot.frameworkDraft.springbootautomationrestapi.tests;

import com.springboot.frameworkDraft.springbootautomationrestapi.maverick.service.config.ConfigService;
import com.springboot.frameworkDraft.springbootautomationrestapi.maverick.service.logger.LogService;
import com.springboot.frameworkDraft.springbootautomationrestapi.maverick.service.restService.restImplementation.RestService;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.response.Response;
import org.testng.annotations.Test;

public class Test1 {

    @Test
    public void TestDemo1(){


        Response res = RestAssured.given()
                .baseUri("https://reqres.in/")
                .basePath("api/users/2")
                .get();

        System.out.println(res.prettyPrint());
    }

    @Test
    public void TestDemo2(){

        ConfigService configService = new ConfigService();
        configService.setProperty("a", 123);
        configService.setProperty("b", "xyz");
        configService.setProperty("c", 1.123);
        configService.setProperty("d", true);



        RequestSpecBuilder builder = new RequestSpecBuilder();
        builder.setBaseUri("https://reqres.in/");
        builder.setBasePath("api/users/2");

        RestService restService = new RestService();
        Response res = restService.get(builder.build());

        System.out.println(res.prettyPrint());

        int a = (int) configService.getProperty("a");
        System.out.println(a);

        String b = (String) configService.getProperty("b");
        System.out.println(b);

        double c = (double) configService.getProperty("c");
        System.out.println(c);

        boolean d = (boolean) configService.getProperty("d");
        System.out.println(d);
        LogService.Info("jhvgjvjgv");
        LogService.Assertion("jhvgjvjgv");

    }

    @Test
    public void verifyLogs(){
        LogService.Assertion("fhhfv");
    }
}
