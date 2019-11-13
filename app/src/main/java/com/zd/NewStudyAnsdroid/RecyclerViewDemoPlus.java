package com.zd.NewStudyAnsdroid;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.listener.OnItemChildClickListener;

import java.util.ArrayList;
import java.util.List;

public class RecyclerViewDemoPlus extends AppCompatActivity {

    private RecyclerView recyclerView;

    private BRVAHDemoAdapter adapter;

    private List<Entity> data;

    private Context context;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_view_demo_plus);
        recyclerView = findViewById(R.id.recycler_view);

        context = this;
        //设置布局管理器

        LinearLayoutManager manager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(manager);

        //设置适配器
        adapter = new BRVAHDemoAdapter(R.layout.item_list_demo,null);

        recyclerView.addOnItemTouchListener(new OnItemChildClickListener() {
            @Override
            public void onSimpleItemChildClick(BaseQuickAdapter adapter, View view, int position) {
                Toast.makeText(context,position+"》》》被点击",Toast.LENGTH_LONG).show();
            }
        });

        DividerItemDecoration itemDecoration = new DividerItemDecoration
                (context,DividerItemDecoration.VERTICAL);
        itemDecoration.setDrawable(getResources().getDrawable(R.drawable.item_divider));

        recyclerView.addItemDecoration(itemDecoration);

        recyclerView.setAdapter(adapter);
        initData();

    }
    private void initData()
    {
        data = new ArrayList<>();
        for (int i = 0; i < 100; i++)
        {
            Entity entity = new Entity("index" + i);
            data.add(entity);
        }

        adapter.setNewData(data);

//        adapter.addData(data);
    }
}
