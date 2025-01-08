package com.needibay.email.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
@ToString
public class EmailDTO {

    @Email(message = "Invalid email format")
    @NotEmpty(message = "Email cannot be empty")
    private String email;

    @NotEmpty(message = "Subject line cannot be empty")
    private String subjectLine;

    @NotEmpty(message = "Template cannot be empty")
    private String template;

    @NotNull(message = "Variable data cannot be null")
    private Object variableData;

    public EmailDTO() {}
}
