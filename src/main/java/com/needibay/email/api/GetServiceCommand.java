package com.needibay.email.api;

import org.springframework.http.client.ClientHttpRequestFactory;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

import java.util.concurrent.CompletableFuture;

public class GetServiceCommand implements IServiceCommand{

    private String otherUrl = "";

    public GetServiceCommand(String requestUrl, ClientHttpRequestFactory c) {
        this.otherUrl = requestUrl;
    }

    @Override
    public Object execute() {

        HttpComponentsClientHttpRequestFactory clientHttpRequestFactory
                = new HttpComponentsClientHttpRequestFactory();
        clientHttpRequestFactory.setConnectTimeout(5000);

        RestTemplate restTemplate = new RestTemplate(clientHttpRequestFactory);
        String requestUrl = ClientConfig.getBaseUrl() + this.otherUrl;
        Object response = restTemplate.getForEntity(requestUrl, Object.class);
        return response;
    }


    @Override
    public CompletableFuture<Object> executeAsync() {
        Object response = execute();
        return CompletableFuture.completedFuture(response);
    }
}
