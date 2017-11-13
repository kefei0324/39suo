package org.feona.engine.rest;

import android.util.Log;
import org.androidannotations.annotations.EBean;
import org.springframework.http.HttpRequest;
import org.springframework.http.client.ClientHttpRequestExecution;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.http.client.ClientHttpResponse;

import java.io.IOException;

/**
 * @AUTHER feona
 * @CREATE 2017/11/10  10:10
 **/
@EBean
public class UserAgentInterceptor implements ClientHttpRequestInterceptor {

    private static final String TAG= "UserAgentInterceptor";

    @Override
    public ClientHttpResponse intercept(HttpRequest request, byte[] body, ClientHttpRequestExecution execution) throws IOException {
        // do something
        Log.d(TAG, request.getURI().toString());
        return execution.execute(request, body);
    }
}
