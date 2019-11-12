package com.zd.NewStudyAnsdroid;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

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
                startActivity(new Intent(view.getContext(),QQsetupPage.class));
            else
                Toast.makeText(this,"请输入用户名或者密码！",Toast.LENGTH_LONG).show();
            break;
        case R.id.bt_regiest:
            startActivity(new Intent(view.getContext(),ImsgDemoActivity.class));
            break;
        }

    }


}
