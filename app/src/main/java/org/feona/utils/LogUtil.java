package org.feona.utils;

import android.util.Log;
import org.androidannotations.annotations.EBean;

/**
 * @AUTHER feona
 * @CREATE 2017/11/9  10:36
 **/
@EBean(scope = EBean.Scope.Singleton)
public class LogUtil {

    private static final String TAG = "LogUtil";

    public void dump(String log){
        Log.d(TAG,log);
    }

}
