package org.feona.engine.rest;

import org.androidannotations.annotations.AfterInject;
import org.androidannotations.annotations.EBean;
import org.feona.base.Constant;
import org.springframework.http.HttpMethod;
import org.springframework.http.client.ClientHttpRequest;
import org.springframework.http.client.ClientHttpRequestFactory;
import org.springframework.http.client.SimpleClientHttpRequestFactory;

import java.io.IOException;
import java.net.URI;

/**
 * @AUTHER feona
 * @CREATE 2017/11/10  10:21
 **/
@EBean
public class UserRequestFactory extends SimpleClientHttpRequestFactory {

    @AfterInject
    protected void init(){
        setConnectTimeout(4*Constant.THOUSAND);
        setReadTimeout(4*Constant.THOUSAND);
    }

    @Override
    public void setConnectTimeout(int connectTimeout) {
        super.setConnectTimeout(connectTimeout);
    }

    @Override
    public void setReadTimeout(int readTimeout) {
        super.setReadTimeout(readTimeout);
    }
}
