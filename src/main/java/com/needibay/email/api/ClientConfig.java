package com.needibay.email.api;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
final class ClientConfig {

    private static String baseUrl;

    public ClientConfig(){}

    public static String getBaseUrl(){
        return baseUrl;
    }

}
