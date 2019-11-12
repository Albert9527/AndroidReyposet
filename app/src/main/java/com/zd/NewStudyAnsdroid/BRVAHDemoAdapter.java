package com.zd.NewStudyAnsdroid;


import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.util.List;

public class BRVAHDemoAdapter extends BaseQuickAdapter<Entity,BaseViewHolder>{

 /*   public BRVAHDemoAdapter(@Nullable List data) {
        super(data);
    }

    public BRVAHDemoAdapter(int layoutResId) {
        super(layoutResId);
    }
*/
    public BRVAHDemoAdapter(int layoutResId, @Nullable List<Entity> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(@NonNull BaseViewHolder helper, Entity item) {
        helper.setText(R.id.tv_text,item.getMsg());
    }
}
