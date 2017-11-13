package org.feona.base;

import android.support.v7.app.AppCompatActivity;
import org.androidannotations.annotations.AfterInject;
import org.androidannotations.annotations.App;
import org.androidannotations.annotations.Bean;
import org.androidannotations.annotations.EActivity;
import org.feona.engine.rest.RestManager;

/**
 * @AUTHER feona
 * @CREATE 2017/11/9  10:08
 **/
@EActivity
public abstract class BaseAct extends AppCompatActivity {

    @Bean
    protected RestManager restManager;

    @App
    protected AppInstance appInstance;

    @AfterInject
    protected void init() {
        appInstance.addAct(this);
    }



}
