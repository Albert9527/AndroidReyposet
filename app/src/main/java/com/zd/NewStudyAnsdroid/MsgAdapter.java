package com.zd.NewStudyAnsdroid;

import androidx.annotation.NonNull;

import com.chad.library.adapter.base.BaseMultiItemQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.util.List;

public class MsgAdapter extends BaseMultiItemQuickAdapter<Msg, BaseViewHolder> {
    /**
     * Same as QuickAdapter#QuickAdapter(Context,int) but with
     * some initialization data.
     *
     * @param data A new list is created out of this one to avoid mutable list
     */
    public MsgAdapter(List<Msg> data) {
        super(data);
        addItemType(Msg.MINE,R.layout.item_mine);
        addItemType(Msg.OTHERS,R.layout.item_other);
    }

    @Override
    protected void convert(@NonNull BaseViewHolder helper, Msg item) {
        switch (item.getItemType()){
            case Msg.MINE :
                helper.setText(R.id.tv_msg_mine,item.getMsg())
                        .setImageResource(R.id.img_mine,item.getImg());
                break;
            case Msg.OTHERS:
                helper.setText(R.id.tv_msg_other,item.getMsg())
                        .setImageResource(R.id.img_other,item.getImg());
                break;

            default:
        }
    }
}
