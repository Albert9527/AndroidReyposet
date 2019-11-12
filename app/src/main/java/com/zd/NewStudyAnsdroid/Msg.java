package com.zd.NewStudyAnsdroid;

import com.chad.library.adapter.base.entity.MultiItemEntity;

public class Msg implements MultiItemEntity {
    public static final int MINE = 0;
    public static final int OTHERS = 1;

    //消息内容
    private String msg;
    private int img;
    private int type;

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public int getImg() {
        return img;
    }

    public void setImg(int img) {
        this.img = img;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    @Override
    public int getItemType() {
        return getType() == 0 ? MINE : OTHERS;
    }
}
