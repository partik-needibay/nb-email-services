package com.needibay.email.libs;

import com.needibay.email.dto.SmsDTOInterface;
import lombok.Data;
import org.springframework.http.HttpHeaders;

@Data
public class Msg91 implements ServiceProviderInterface {

    private String Msg91Url;

    private Object msg91RequestBody;

    private HttpHeaders msg91Headers;

    @Override
    public Object getRequestBody() {
        return this.getMsg91RequestBody();
    }


    @Override
    public HttpHeaders getHeaders() {
        return this.getMsg91Headers();
    }

    @Override
    public String getUrl() {
        return this.Msg91Url;
    }


    public void setMsg91RequestBody(SmsDTOInterface smsDTOInterface){
        this.msg91RequestBody = smsDTOInterface;
    }

}
