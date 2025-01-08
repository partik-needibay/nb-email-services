package com.needibay.email.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import org.springframework.beans.factory.annotation.Qualifier;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.List;

@Data
@Qualifier("orderPlaced")
public class Msg91OrderPlacedDTO implements SmsDTOInterface {

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

        private String mobiles;
        private String name;
        private String orderId;

    }*/

    public Msg91OrderPlacedDTO(){}
}
