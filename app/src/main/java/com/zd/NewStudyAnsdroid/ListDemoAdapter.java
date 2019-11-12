package com.zd.NewStudyAnsdroid;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

public class ListDemoAdapter extends RecyclerView.Adapter<ListDemoAdapter.ListViewHolder>{
    private List<Entity> data;

    public ListDemoAdapter(List<Entity> data){
        this.data = data;
    }

    public void setData(List<Entity> data) {
        this.data = data;
        //刷新数据
        notifyDataSetChanged();
    }

    /**
     * 创建一个ViewHolder并返回
     * @param parent 相当于Item盛放的容器
     * @param viewType 指定布局文件的类型
     * @return 返回ViewHolder对象
     */

    @NonNull
    @Override
    public ListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // 指定对应的布局文件
        View view  = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_list_demo, parent, false);
        return new ListViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ListViewHolder holder, int position) {

        Entity entity = data.get(position);
        holder.textView.setText(entity.getMsg());
    }

    @Override
    public int getItemCount() {
        return data == null ? 0 : data.size();
    }

    static class ListViewHolder extends RecyclerView.ViewHolder{
        TextView textView;
        public ListViewHolder(@NonNull View itemView){

            //获取itemUi
            super(itemView);
            textView = itemView.findViewById(R.id.tv_text);
        }
    }
}
