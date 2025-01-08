package com.needibay.email.service;


import com.needibay.email.api.IServiceCommand;
import com.needibay.email.api.PostServiceCommand;
import com.needibay.email.api.ServiceInvoker;
import com.needibay.email.dto.SmsDTOInterface;
import com.needibay.email.libs.Msg91;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Service;

@Service
public class SmsServiceMsg91 implements SmsService  {

    @Override
    public void send(SmsDTOInterface smsDTO) {

        HttpHeaders headers = new HttpHeaders();

        // Needs to be fetched from system configuration table
        headers.set("authkey", "413575AE3k7Cq866c87c81P1");
        headers.set("Content-Type", "application/json");

        Msg91 msg91 = new Msg91();
        msg91.setMsg91Headers(headers);
        msg91.setMsg91RequestBody(smsDTO);
        msg91.setMsg91Url("https://api.msg91.com/api/v5/flow/");

        IServiceCommand serviceCommand = new PostServiceCommand(msg91);
        ServiceInvoker serviceInvoker = new ServiceInvoker(serviceCommand);
        serviceInvoker.ExecuteRequest();
    }

}
