package com.needibay.email.api.request;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class SendOtp {

    private String email;

    private String otp;

    public SendOtp(){}
}
