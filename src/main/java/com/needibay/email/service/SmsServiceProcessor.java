package com.needibay.email.service;

import com.needibay.email.dto.SmsDTOInterface;
import com.needibay.email.repository.ConfigurationRepo;
import com.needibay.email.entity.Configuration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.lang.reflect.InvocationTargetException;

@Service
public class SmsServiceProcessor {

    @Autowired
    ConfigurationRepo configurationRepo;


    @Autowired
    SmsService smsService;

    @Autowired
    public SmsServiceProcessor(ConfigurationRepo theConfigurationRepo, SmsService theSmsService){
        configurationRepo = theConfigurationRepo;
        smsService = theSmsService;
    }

    // Fetch selected admin configuration

    public void send(SmsDTOInterface smsDTOInterface) throws ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchMethodException, InvocationTargetException {
        Configuration config = configurationRepo.findByConfigKey("SMS_SERVICE");
        Class c1 = Class.forName("com.needibay.email.service." + config.getConfigValue());
        SmsService smsService = (SmsService) c1.getDeclaredConstructor().newInstance();
        smsService.send(smsDTOInterface);
    }

}
