package com.springboot.frameworkDraft.springbootautomationrestapi.aut.reqResDotIn.source.helper.createUser;

import com.springboot.frameworkDraft.springbootautomationrestapi.aut.reqResDotIn.source.dto.createUser.CreateUserResponseDto;
import com.springboot.frameworkDraft.springbootautomationrestapi.aut.reqResDotIn.source.helper.createUser.facade.CreateUserRequestHelper;
import com.springboot.frameworkDraft.springbootautomationrestapi.aut.reqResDotIn.source.helper.createUser.facade.CreateUserResponseHelper;
import com.springboot.frameworkDraft.springbootautomationrestapi.aut.reqResDotIn.source.helper.sourceBase.SourceBase;
import com.springboot.frameworkDraft.springbootautomationrestapi.maverick.service.config.ConfigService;

public class CreateUserHelper extends SourceBase {


    /**
     *
     */
    public void callAndValidateApi() {
        CreateUserRequestHelper createUserRequestHelper = new CreateUserRequestHelper();
        CreateUserResponseDto createUserResponseDto = createUserRequestHelper.callApi();

        CreateUserResponseHelper createUserResponseHelper = new CreateUserResponseHelper();
        createUserResponseHelper.validateResponse(createUserResponseDto);
    }

    /**
     * @param rowNum
     */
    public void callAndValidateApi(int rowNum) {

    }
}
