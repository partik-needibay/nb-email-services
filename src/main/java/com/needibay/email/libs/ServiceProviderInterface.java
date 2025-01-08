package com.needibay.email.libs;

import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.validation.ObjectError;


public interface ServiceProviderInterface {

    public Object getRequestBody();

    public HttpHeaders getHeaders();

    public String getUrl();
}
