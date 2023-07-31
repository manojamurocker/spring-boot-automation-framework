package com.springboot.frameworkDraft.springbootautomationrestapi.phantom.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.testng.TestNG;
import org.testng.xml.XmlClass;
import org.testng.xml.XmlSuite;
import org.testng.xml.XmlTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

@RestController
public class TestngController {

    @GetMapping("run")
    public ResponseEntity<String> runTestNg() {
        createTestNGFile();
        return ResponseEntity.ok("Here");
    }

/*    private void runMvn() {
        Process theProcess = null;
        try {
            theProcess = Runtime.getRuntime().exec("mvn clean test -DsuiteXmlFile=xmlFiles/testng.xml");
        } catch (IOException e) {
            System.err.println("Error on exec() method");
            e.printStackTrace();
        }

        BufferedReader inStream;
// read from the called program's standard output stream
        try {
            inStream = new BufferedReader(new InputStreamReader(theProcess.getInputStream()));
            System.out.println(inStream.readLine());
        } catch (IOException e) {
            System.err.println("Error on inStream.readLine()");
            e.printStackTrace();
        }

    }*/


    private void createTestNGFile(){
        XmlSuite suite = new XmlSuite();
        suite.setName("some name"); // this means <suite name = "codekru">

        XmlTest test = new XmlTest(suite);
        test.setName("codekru"); // this means <test name = "codekru">
        List<XmlClass> classes = new ArrayList<>(); // <classes>
        classes.add(new XmlClass("com.springboot.frameworkDraft.springbootautomationrestapi.automation.tests.Test1")); // this means <class name = "Test.CodekruTest">
        test.setXmlClasses(classes);

        String listener = "com.springboot.frameworkDraft.springbootautomationrestapi.maverick.service.report.CustomEmailableReport";
        suite.addListener(listener);

        List<XmlSuite> suites = new ArrayList<XmlSuite>();
        suites.add(suite);
        TestNG testng = new TestNG();
        testng.setXmlSuites(suites);
        testng.run();
    }

}
