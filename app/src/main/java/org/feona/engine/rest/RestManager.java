package org.feona.engine.rest;

import android.util.Log;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.androidannotations.annotations.*;
import org.androidannotations.rest.spring.annotations.RestService;
import org.feona.base.Constant;
import org.feona.entity.Student;
import org.json.JSONObject;

import java.util.List;

/**
 * @AUTHER feona
 * @CREATE 2017/11/10  10:43
 **/
@EBean(scope = EBean.Scope.Singleton)
public class RestManager {

    private static final String TAG = "RestManager";

    @RestService
    RestClient restClient;
    @Bean
    UserErrorHandler userErrorHandler;
    @Bean
    UserRequestFactory userRequestFactory;

    @AfterInject
    void afterInject() {
        userRequestFactory.setConnectTimeout(2 * Constant.THOUSAND);
        userRequestFactory.setReadTimeout(2 * Constant.THOUSAND);
//        restClient.getRestTemplate().setRequestFactory(userRequestFactory);
        restClient.setRestErrorHandler(userErrorHandler);
    }

    @Background
    public void testRestTimeOut() {
        String result = restClient.testRestTimeOut();
        showResult(result);
    }

    @Background
    public void getAllStudent(int id, RestListener listener) {
        BaseResponse<List<Student>> response = restClient.getAllStudent(id);

//        List<Student>students= (List<Student>) response.getResult();
//        for (Student student : students) {
//            showResult(student.getName());
//        }
//        showResult(students);
        dumpObject(response);
        if (response.getSuccess()) {
            listener.onResult(response.getResult());
        } else {
            listener.onError(response.getMessage());
        }
    }

    @UiThread
    public void showResult(String res) {
        Log.v(TAG, res);
    }

    /**
     * 输出网络请求日志
     *
     * @param baseResponse
     */
    private void dumpObject(BaseResponse baseResponse) {

        Gson gson = new Gson();
        Log.v(TAG, "dumpObject:");
        Log.v(TAG, gson.toJson(baseResponse));

    }
}
