package com.springboot.frameworkDraft.springbootautomationrestapi.aut.reqResDotIn.source.dto.createUser;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "name",
        "job"
})
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Component
public class CreateUserRequestDto {

    @JsonProperty("name")
    public String name;
    @JsonProperty("job")
    public String job;

}
