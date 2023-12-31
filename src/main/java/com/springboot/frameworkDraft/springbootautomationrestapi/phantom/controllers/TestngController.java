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
        try {
            runMvnCmd();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return ResponseEntity.ok("Here");
    }

    private void runMvnCmd() throws IOException {
        // The actual procedure for process execution:
        //runCommand(String cmd);
        // Create a list for storing output.
        ArrayList list = new ArrayList();
        // Execute a command and get its process handle
        String cmd = "mvn clean test -DsuiteXmlFile=xmlFiles/testng.xml";
        Process proc = Runtime.getRuntime().exec(cmd);
        // Get the handle for the processes InputStream
//        InputStream istr = proc.getInputStream();
//        // Create a BufferedReader and specify it reads
//        // from an input stream.
//
//        BufferedReader br = new BufferedReader(new InputStreamReader(istr));
//        String str; // Temporary String variable
//        // Read to Temp Variable, Check for null then
//        // add to (ArrayList)list
//        while ((str = br.readLine()) != null)
//            list.add(str);
//        // Wait for process to terminate and catch any Exceptions.
//        try {
//            proc.waitFor();
//        }
//        catch (InterruptedException e) {
//            System.err.println("Process was interrupted");
//        }
//        // Note: proc.exitValue() returns the exit value.
//        // (Use if required)
//        br.close(); // Done.
//        // Convert the list to a string and return
//        return (String[])list.toArray(new String[0]);
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
        classes.add(new XmlClass("com.springboot.frameworkDraft.springbootautomationrestapi.aut.reqResDotIn.tests.Test1")); // this means <class name = "Test.CodekruTest">
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
