package com.zd.NewStudyAnsdroid;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private EditText editTextu,editTextp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getview();
    }

    public void getview(){
        editTextu = findViewById(R.id.et_username);
        editTextp = findViewById(R.id.et_password);
    }
    public void login_listener(View view){

        switch (view.getId()){
        case R.id.bt_login:
            if (editTextu.getText()!=null&&editTextp.getText()!=null)
            Toast.makeText(this,editTextu.getText().toString()+"已登录",Toast.LENGTH_LONG).show();
            else
                Toast.makeText(this,"请输入用户名或者密码！",Toast.LENGTH_LONG).show();
            break;
        case R.id.bt_regiest:
            Toast.makeText(this,"该功能还在开发中！",Toast.LENGTH_LONG).show();
            break;
        }

    }


}
