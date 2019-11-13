package com.zd.NewStudyAnsdroid;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class ImsgDemoActivity extends AppCompatActivity {

    private RecyclerView msgList;
    private MsgAdapter adapter;
    private EditText editText;
    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_imsg_demo);
        msgList = findViewById(R.id.recycler_view );
        msgList.setLayoutManager(new LinearLayoutManager(this));

        adapter = new MsgAdapter(null);
        msgList.setAdapter(adapter);

        editText = findViewById(R.id.et_input);
        button = findViewById(R.id.bt_getmsg);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String msg = editText.getText().toString();
                Msg entity = new Msg();
                entity.setMsg(msg);
                entity.setImg(R.drawable.ic_launcher_background);
                adapter.addData(entity);

                Msg other = new Msg();
                other.setType(Msg.OTHERS);
                other.setImg(R.drawable.ic_launcher_foreground);
                other.setMsg("hello----");

                adapter.addData(other);

                editText.setText("");
            }
        });
    }
}
