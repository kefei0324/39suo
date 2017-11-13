package org.feona.engine.rest;

import android.util.Log;
import org.androidannotations.annotations.EBean;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.web.client.ResponseErrorHandler;

import java.io.IOException;

/**
 * @AUTHER feona
 * @CREATE 2017/11/10  10:32
 **/
@EBean
public class UserResponseErrorHandler implements ResponseErrorHandler {

    private static final String TAG = "UserResponseError";

    @Override
    public boolean hasError(ClientHttpResponse response) throws IOException {
        return false;
    }

    @Override
    public void handleError(ClientHttpResponse response) throws IOException {

        Log.e(TAG,"response handle error");
    }
}
