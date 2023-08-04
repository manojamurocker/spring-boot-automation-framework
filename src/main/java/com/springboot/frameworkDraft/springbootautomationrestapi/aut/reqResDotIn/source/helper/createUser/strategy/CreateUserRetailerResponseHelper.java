package com.springboot.frameworkDraft.springbootautomationrestapi.aut.reqResDotIn.source.helper.createUser.strategy;

import com.springboot.frameworkDraft.springbootautomationrestapi.maverick.service.assertion.AssertionService;
import com.springboot.frameworkDraft.springbootautomationrestapi.maverick.service.logger.LogService;
import org.springframework.stereotype.Component;

@Component
public class CreateUserRetailerResponseHelper extends CreateUserStrategy{
    /**
     *
     */
    @Override
    public void verifyResponse() {
        AssertionService Assert = new AssertionService();
        Assert.assertNotNull("Verified for user retailer", "user as retailer");
        LogService.Assertion("Verified for user retailer");

    }
}
