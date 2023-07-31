package com.springboot.frameworkDraft.springbootautomationrestapi.maverick.service.logger;

import com.springboot.frameworkDraft.springbootautomationrestapi.maverick.service.assertion.AssertionService;
import com.springboot.frameworkDraft.springbootautomationrestapi.maverick.service.config.ConfigService;
import com.springboot.frameworkDraft.springbootautomationrestapi.maverick.service.restService.restImplementation.RestService;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public class LogService {

/*    static {
        ConfigurationFactory custom = new CustomConfigFactory();
        ConfigurationFactory.setConfigurationFactory(custom);
    }*/
    private static Logger Log = LogManager.getLogger();


    public static void Req(String message){
        LogService.req(message);
    }

    public static void Assertion(String message){
        LogService.assertion(message);
    }

    public static void Res(String message){
        LogService.res(message);
    }

    public static void Debug(String message){
        LogService.debug(message);
    }

    public static void Info(String message){
        LogService.info(message);
    }

    private static void req(String message){
        StackTraceElement ste = getCallerClassName();
        int lineNumber = ste.getLineNumber();
        String methodName = ste.getMethodName();
        message = "["+methodName+":"+lineNumber+"] : " + message;
        Log = LogManager.getLogger(ste.getClassName());
        Log.log(Level.forName("REQUEST", 350), message);
    }

    private static void assertion(String message){
        StackTraceElement ste = getCallerClassName();
        int lineNumber = ste.getLineNumber();
        String methodName = ste.getMethodName();
        message = "["+methodName+":"+lineNumber+"] : " + message;
        Log = LogManager.getLogger(ste.getClassName());
        Log.log(Level.forName("ASSERTION", 250), message);
    }

    private static void res(String message){
        StackTraceElement ste = getCallerClassName();
        int lineNumber = ste.getLineNumber();
        String methodName = ste.getMethodName();
        message = "["+methodName+":"+lineNumber+"] : " + message;
        Log = LogManager.getLogger(ste.getClassName());
        Log.log(Level.forName("RESPONSE", 150), message);
    }

    private static void debug(String message){
        StackTraceElement ste = getCallerClassName();
        int lineNumber = ste.getLineNumber();
        String methodName = ste.getMethodName();
        message = "["+methodName+":"+lineNumber+"] : " + message;
        Log = LogManager.getLogger(ste.getClassName());
        Log.debug(message);
    }

    private static void info(String message){
        StackTraceElement ste = getCallerClassName();
        int lineNumber = ste.getLineNumber();
        String methodName = ste.getMethodName();
        message = "["+methodName+":"+lineNumber+"] : " + message;
        Log = LogManager.getLogger(ste.getClassName());
        Log.info(message);
    }

    public static StackTraceElement getCallerClassName(){
        StackTraceElement[] stackTraceElements = Thread.currentThread().getStackTrace();
        for(int i=1; i < stackTraceElements.length; i++){
            StackTraceElement ste = stackTraceElements[i];
            if( !ste.getClassName().equals(ConfigService.class.getName()) && !ste.getClassName().equals(RestService.class.getName()) && !ste.getClassName().equals(AssertionService.class.getName()) && !ste.getClassName().equals(LogService.class.getName()) && ste.getClassName().indexOf("java.lang.thread") != 0){
                return ste;
            }
        }
        return null;
    }
}
