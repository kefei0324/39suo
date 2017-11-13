package org.feona.engine.rest;

import android.util.Log;
import org.androidannotations.annotations.EBean;
import org.androidannotations.rest.spring.api.RestErrorHandler;
import org.springframework.core.NestedRuntimeException;

/**
 * @AUTHER feona
 * @CREATE 2017/11/10  10:38
 **/
@EBean
public class UserErrorHandler implements RestErrorHandler {

    private static final String TAG = "UserErrorHandler";

    @Override
    public void onRestClientExceptionThrown(NestedRuntimeException e) {
        Log.e(TAG,e.getCause()+"\n"+e.getMessage());

        //记录异常信息


    }
}
