package com.springboot.frameworkDraft.springbootautomationrestapi.aut.reqResDotIn.source.helper.createUser;

import com.springboot.frameworkDraft.springbootautomationrestapi.aut.reqResDotIn.source.dto.createUser.CreateUserResponseDto;
import com.springboot.frameworkDraft.springbootautomationrestapi.aut.reqResDotIn.source.helper.createUser.facade.CreateUserRequestHelper;
import com.springboot.frameworkDraft.springbootautomationrestapi.aut.reqResDotIn.source.helper.createUser.facade.CreateUserResponseHelper;
import com.springboot.frameworkDraft.springbootautomationrestapi.aut.reqResDotIn.source.helper.sourceBase.SourceBase;
import com.springboot.frameworkDraft.springbootautomationrestapi.maverick.service.config.ConfigService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CreateUserHelper extends SourceBase {

    @Autowired
    protected CreateUserResponseHelper createUserResponseHelper;

    @Autowired
    protected CreateUserRequestHelper createUserRequestHelper;

    /**
     *
     */
    public void callAndValidateApi() {
        CreateUserResponseDto createUserResponseDto = createUserRequestHelper.callApi();
        createUserResponseHelper.validateResponse(createUserResponseDto);
    }

}
