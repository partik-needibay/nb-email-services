package com.needibay.email.dto;

import java.util.ArrayList;
import java.util.List;

public interface SmsDTOInterface {

    String getTemplateId();

    Boolean getShortUrl();

    String getSender();

    List<Object> getRecipients();

    static SmsFactory factory() {
        return new SmsFactory();
    }
}
