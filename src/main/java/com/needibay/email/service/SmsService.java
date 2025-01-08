package com.needibay.email.service;


import com.needibay.email.dto.SmsDTOInterface;

public interface SmsService {

    public void send(SmsDTOInterface smsDTO);
}
