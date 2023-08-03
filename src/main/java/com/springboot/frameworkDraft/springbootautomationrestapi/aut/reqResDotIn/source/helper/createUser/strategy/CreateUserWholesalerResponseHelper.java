package com.springboot.frameworkDraft.springbootautomationrestapi.aut.reqResDotIn.source.helper.createUser.strategy;

import com.springboot.frameworkDraft.springbootautomationrestapi.maverick.service.assertion.AssertionService;
import com.springboot.frameworkDraft.springbootautomationrestapi.maverick.service.logger.LogService;

public class CreateUserWholesalerResponseHelper extends CreateUserStrategy{
    /**
     *
     */
    @Override
    public void verifyResponse() {
        AssertionService Assert = new AssertionService();
        Assert.assertNotNull("Verified for user wholesaler", "user as wholesaler");
        LogService.Assertion("Verified for user wholesaler");

    }
}
