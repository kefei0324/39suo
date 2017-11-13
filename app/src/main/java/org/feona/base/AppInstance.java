package org.feona.base;

import android.app.Application;
import android.util.Log;
import android.widget.Toast;
import org.androidannotations.annotations.Background;
import org.androidannotations.annotations.EApplication;
import org.feona.BuildConfig;

import java.util.ArrayList;
import java.util.List;

/**
 * @AUTHER feona
 * @CREATE 2017/11/9  10:11
 **/
@EApplication
public class AppInstance extends Application {

    private static final String TAG = "Application";

    private List<BaseAct> acts;

    public void onCreate() {
        super.onCreate();
        initSomeStuff();
    }

    @Background
    void initSomeStuff() {
        acts = new ArrayList<>();
    }

    public void addAct(BaseAct act) {
        if (null != acts) {
            if (!acts.contains(act)) {
                Log.v(TAG, "add act[" + act.getClass().getSimpleName() + "] to app's acts.");
                acts.add(0, act);
            }
        }
    }

    public void removeAct(BaseAct act) {
        if (null != acts) {
            if (acts.contains(act)) {
                Log.v(TAG, "remove act[" + act.getClass().getSimpleName() + "] from app's acts.");
                acts.remove(act);
            }
        }
    }

    public void showToast(String tip) {
        Toast.makeText(this, tip, Toast.LENGTH_SHORT).show();
    }

    public void showTestToast(String tip) {
        if (BuildConfig.DEBUG) {
            Toast.makeText(this, tip, Toast.LENGTH_SHORT).show();
        }
    }

}
