package com.needibay.email.controller;

import com.needibay.email.dto.EmailDTO;
import com.needibay.email.dto.Msg91OrderPlacedDTO;
import com.needibay.email.dto.Msg91OtpDTO;
import com.needibay.email.service.*;
import com.needibay.email.entity.Configuration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.lang.reflect.InvocationTargetException;

@RestController
@RequestMapping("/")
public class EmailController {

    @Autowired
    EmailService emailService;

    @Autowired
    SmsService smsService;

    @Autowired
    SmsServiceProcessor smsServiceProcessor;

    @Autowired
    EmailServiceProcessor emailServiceProcessor;

    @Autowired
    Config config;

    @Autowired
    public EmailController(Config theConfig, EmailService theEmailService,
                           EmailServiceProcessor theEmailServiceProcessor,
                           SmsServiceProcessor theSmsServiceProcessor){
        config = theConfig;
        emailService =  theEmailService;
        emailServiceProcessor = theEmailServiceProcessor;
        smsServiceProcessor = theSmsServiceProcessor;
    }

    @PostMapping("/send")
    public void sendEmail(@Valid @RequestBody EmailDTO emailDTO) throws ClassNotFoundException, InstantiationException, IllegalAccessException, InvocationTargetException, NoSuchMethodException {
        System.out.print("======================================");
        //templateEngineService.testingInstance();
        System.out.print("======================================");
        emailServiceProcessor.send(emailDTO);
    }

    @PostMapping("/send/otp")
    public void sendOtp(@Valid @RequestBody Msg91OtpDTO msg91OtpDTO) throws ClassNotFoundException, InstantiationException, IllegalAccessException, InvocationTargetException, NoSuchMethodException {
        System.out.print(msg91OtpDTO.getRecipients());
        smsServiceProcessor.send(msg91OtpDTO);
    }

    @PostMapping("/send/order-placed")
    public void sendOrderPlaced(@Valid @RequestBody Msg91OrderPlacedDTO msg91OrderPlacedDTO) throws ClassNotFoundException, InstantiationException, IllegalAccessException, InvocationTargetException, NoSuchMethodException {

        smsServiceProcessor.send(msg91OrderPlacedDTO);
    }

    @GetMapping("/config")
    public Configuration getConfiguration(HttpServletRequest req)
    {
        throw new RuntimeException("Forced 500 Internal Server Error for testing purposes");
//        return config.findByOptionKey("EMAIL_SERVICE");
    }

}
