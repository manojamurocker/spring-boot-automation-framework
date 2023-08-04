package com.springboot.frameworkDraft.springbootautomationrestapi.aut.reqResDotIn.source.helper.sourceBase;

import com.springboot.frameworkDraft.springbootautomationrestapi.maverick.service.config.ConfigService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;


@Component
public abstract class SourceBase{

    @Autowired
    protected ConfigService<Object> configService;
}
