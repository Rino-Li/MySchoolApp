package cn.edu.uzz.activity.myschool;


import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import cn.smssdk.EventHandler;
import cn.smssdk.SMSSDK;


public class LoginActivity extends AppCompatActivity implements View.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        EditText stu_account;
        EditText stu_pwd;
        Button login;
        TextView forgetpwd;
        EventHandler eventHandler;
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        //以下为短信验证-------------------------------------------------------------------
        // 如果希望在读取通信录的时候提示用户，可以添加下面的代码，并且必须在其他代码调用之前，否则不起作用；如果没这个需求，可以不加这行代码
        //SMSSDK.setAskPermisionOnReadContact(boolShowInDialog);

        // 创建EventHandler对象
        eventHandler = new EventHandler() {
            public void afterEvent(int event, int result, Object data) {
                if (data instanceof Throwable) {
                    Throwable throwable = (Throwable)data;
                    String msg = throwable.getMessage();
                    Toast.makeText(LoginActivity.this, msg, Toast.LENGTH_SHORT).show();
                } else {
                    if (event == SMSSDK.EVENT_GET_VERIFICATION_CODE) {
                        // 处理你自己的逻辑
                    }
                }
            }
        };

        // 注册监听器

        SMSSDK.registerEventHandler(eventHandler);
        //以上为短信验证------------------------------------------------------------------

        stu_account= (EditText) findViewById(R.id.stu_account);


        stu_pwd= (EditText) findViewById(R.id.stu_pwd);


        login= (Button) findViewById(R.id.login);
        login.setOnClickListener(this);

        forgetpwd= (TextView) findViewById(R.id.forgetpwd);
        forgetpwd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(LoginActivity.this,RegistActivity.class);
                startActivity(intent);
            }
        });
    }

    @Override
    public void onClick(View v) {

    }
}
