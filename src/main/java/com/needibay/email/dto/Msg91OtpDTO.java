package com.needibay.email.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import org.springframework.beans.factory.annotation.Qualifier;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

@Qualifier("otp")
@Data
public class Msg91OtpDTO implements SmsDTOInterface {

    @JsonProperty("template_id")
    @NotEmpty(message = "Template ID cannot be empty")
    private String templateId;

    @JsonProperty("short_url")
    private Boolean shortUrl;

    @NotEmpty(message = "Sender cannot be empty")
    private String sender;

    @NotEmpty(message = "Recipients list cannot be empty")
    @Valid
    private List<@NotNull(message = "Recipient cannot be null") Object> recipients;

    /*@Data
    public static class Recipients{

        @NotEmpty(message = "Mobile number cannot be empty")
        private String mobiles;

        @NotEmpty(message = "Name cannot be empty")
        private String name;

        @NotEmpty(message = "OTP cannot be empty")
        private String otp;

    }*/

    public Msg91OtpDTO(){}

    public Msg91OtpDTO provide() {
        return this;
    }
}

