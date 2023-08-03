package com.springboot.frameworkDraft.springbootautomationrestapi.aut.reqResDotIn.source.helper.createUser.facade;

import com.springboot.frameworkDraft.springbootautomationrestapi.aut.reqResDotIn.source.dto.createUser.CreateUserResponseDto;
import com.springboot.frameworkDraft.springbootautomationrestapi.aut.reqResDotIn.source.helper.createUser.strategy.*;
import com.springboot.frameworkDraft.springbootautomationrestapi.aut.reqResDotIn.source.helper.sourceBase.SourceBase;
import com.springboot.frameworkDraft.springbootautomationrestapi.maverick.service.config.ConfigService;
import com.springboot.frameworkDraft.springbootautomationrestapi.maverick.service.logger.LogService;
import org.testng.Assert;

public class CreateUserResponseHelper extends SourceBase {

    CreateUserResponseDto createUserResponseDto;

    public void validateResponse(CreateUserResponseDto createUserResponseDto){
        this.createUserResponseDto = createUserResponseDto;
        verifyCommonResponse();
        verifyUserStrategyResponse();
    }

    private void verifyCommonResponse(){
        LogService.Assertion("Fetched Thread Id:"+ this.configService.getProperty("ThreadIdName"));
        LogService.Assertion("Response Thread Id:"+ Thread.currentThread().getId());
        Assert.assertNotNull(createUserResponseDto.getName());
        LogService.Info(createUserResponseDto.getName());
    }

    private void verifyUserStrategyResponse(){
        String userType = (String) configService.getProperty("UserType");


        CreateUserStrategy userStrategy = null;
        if(userType == null){
            userStrategy = new CreateUserRetailerResponseHelper();
        }else {
            switch (userType.toLowerCase()) {
                case "wholesaler":
                    userStrategy = new CreateUserWholesalerResponseHelper();
                    break;
                case "distributor":
                    userStrategy = new CreateUserDistributorResponseHelper();
                    break;
                case "wholesalestore":
                    userStrategy = new CreateUserWholesaleStoreResponseHelper();
                    break;
                case "retailer":
                default:
                    userStrategy = new CreateUserRetailerResponseHelper();
            }
        }

        userStrategy.verifyResponse();

    }
}
