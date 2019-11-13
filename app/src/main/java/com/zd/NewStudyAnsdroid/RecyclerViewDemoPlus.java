package com.zd.NewStudyAnsdroid;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.listener.OnItemChildClickListener;

import java.util.ArrayList;
import java.util.List;

public class RecyclerViewDemoPlus extends AppCompatActivity {

    private RecyclerView recyclerView;

    private BRVAHDemoAdapter adapter;

    private List<Entity> data;

    private Context context;
    private int newdata = 0;
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

        //刷新功能
        final SwipeRefreshLayout refreshLayout = findViewById(R.id.layout_refresh);
        refreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                //创建线程
                /*new Thread(new Runnable() {
                    @Override
                    public void run() {
                        //todo
                    }
                }).start();*/
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        loadDate();
                        refreshLayout.setRefreshing(false);
                    }
                },2000);
            }
        });


        recyclerView.setAdapter(adapter);
        loadDate();

    }
    private void loadDate()
    {
        data = new ArrayList<>();
        for (int i = 1; i <= 10; i++)
        {
            newdata++;
            Entity entity = new Entity("index" + newdata);
            data.add(entity);
        }

  //      adapter.setNewData(data);

        adapter.addData(data);
    }
}
