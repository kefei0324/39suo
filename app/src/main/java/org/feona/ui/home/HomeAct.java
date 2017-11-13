package org.feona.ui.home;

import android.widget.Button;
import android.widget.TextView;
import org.androidannotations.annotations.*;
import org.feona.R;
import org.feona.base.BaseAct;
import org.feona.engine.rest.RestListener;
import org.feona.entity.Student;

import java.util.Iterator;
import java.util.List;

/**
 * @AUTHER feona
 * @CREATE 2017/11/10  14:00
 **/
@EActivity(R.layout.act_home)
public class HomeAct extends BaseAct {


    @ViewById(R.id.tv_home)
    TextView tv;
    @Click(R.id.btn_home)
    void testRestTimeOut(){

        restManager.testRestTimeOut();

    }
    @Click(R.id.btn_home_student)
    void testStudent(){
        RestListener<List<Student>> listener = new RestListener<List<Student>>(){

            @Override
            public void prepare() {

            }

            @Override
            @UiThread
            public void onResult(List<Student> students) {
                StringBuilder sb = new StringBuilder();
                Iterator iterator = students.iterator();
                while (iterator.hasNext()){
                    Student next = (Student) iterator.next();
                    sb.append(next.toString());
                }
                tv.setText(sb.toString());

            }

            @Override
            public void onError(List<Student> students) {

            }
        };

        restManager.getAllStudent(0,listener);
    }

}
