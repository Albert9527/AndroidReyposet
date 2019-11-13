package com.zd.NewStudyAnsdroid;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


import java.util.ArrayList;
import java.util.List;

public class RecyclerViewActivity extends AppCompatActivity {

    private RecyclerView recyclerView;

    private ListDemoAdapter adapter;

    private List<Entity> data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_view);
        recyclerView = findViewById(R.id.recycler_view);

        //第一步 设置布局管理器
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        //设置适配器
        adapter = new ListDemoAdapter(null);

       OnItemClickListener listener = new OnItemClickListener(){
           @Override
           public void itemClick(int position, View view) {
               Toast.makeText(view.getContext(),position+"被点击",Toast.LENGTH_LONG).show();
            }
       };
       adapter.setOnItemClickListener(listener);
        recyclerView.setAdapter(adapter);
        initData();
    }

    private void initData() {
        data = new ArrayList<>();
        for (int i = 0; i < 100; i++)
        {
            Entity entity = new Entity("index" + i);
            data.add(entity);
        }

        adapter.setData(data);
    }

    public static interface OnItemClickListener{
        void itemClick(int position, View view);
    }
}
