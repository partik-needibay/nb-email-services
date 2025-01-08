package com.needibay.email.dto;

public class SmsFactory {

    public SmsDTOInterface createMsg91Otp() {
        return new Msg91OtpDTO();
    }

    public SmsDTOInterface createMsg91OrderPlaced() {
        return new Msg91OrderPlacedDTO();
    }
}
