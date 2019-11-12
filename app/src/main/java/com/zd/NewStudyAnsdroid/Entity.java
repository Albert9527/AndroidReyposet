package com.zd.NewStudyAnsdroid;

import android.os.Parcel;
import android.os.Parcelable;

public class Entity implements Parcelable {

    private int count;

    private String msg;

    public Entity(int count) {
        this.count = count;
    }

    public Entity(int count, String msg) {
        this.count = count;
        this.msg = msg;
    }

    public Entity(String msg) {
        this.msg = msg;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.count);
        dest.writeString(this.msg);
    }

    protected Entity(Parcel in) {
        this.count = in.readInt();
        this.msg = in.readString();
    }

    public static final Parcelable.Creator<Entity> CREATOR = new Parcelable.Creator<Entity>(){

        @Override
        public Entity createFromParcel(Parcel source) {
            return new Entity(source);
        }

        @Override
        public Entity[] newArray(int size) {
            return new Entity[size];
        }
    };

}
