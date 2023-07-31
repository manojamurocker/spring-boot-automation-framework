package com.springboot.frameworkDraft.springbootautomationrestapi.aut.reqResDotIn.source.helper.createUser;

import com.springboot.frameworkDraft.springbootautomationrestapi.aut.reqResDotIn.source.dto.createUser.CreateUserResponseDto;
import com.springboot.frameworkDraft.springbootautomationrestapi.aut.reqResDotIn.source.helper.sourceBase.SourceBase;

public class CreateUserHelper extends SourceBase {


    /**
     *
     */
    @Override
    public void callAndValidateApi() {
        CreateUserRequestHelper createUserRequestHelper = new CreateUserRequestHelper();
        CreateUserResponseDto createUserResponseDto = createUserRequestHelper.callApi();

        CreateUserResponseHelper createUserResponseHelper = new CreateUserResponseHelper();
        createUserResponseHelper.validateResponse(createUserResponseDto);
    }

    /**
     * @param rowNum
     */
    @Override
    public void callAndValidateApi(int rowNum) {

    }
}
