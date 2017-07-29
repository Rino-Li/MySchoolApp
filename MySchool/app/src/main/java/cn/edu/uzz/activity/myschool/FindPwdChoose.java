package cn.edu.uzz.activity.myschool;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;



/**
 * Created by 10616 on 2017/7/27.
 */

public class FindPwdChoose extends AppCompatActivity{
    Button button;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_findpwdchoose);
        button= (Button) findViewById(R.id.button);
    }
}
