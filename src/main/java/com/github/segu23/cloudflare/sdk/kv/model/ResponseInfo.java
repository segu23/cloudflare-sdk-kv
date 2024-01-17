package com.github.segu23.cloudflare.sdk.kv.model;

import com.google.gson.annotations.SerializedName;

public class ResponseInfo {

    @SerializedName("count")
    private int count;
    @SerializedName("cursor")
    private String cursor;

    public ResponseInfo(int count, String cursor) {
        this.count = count;
        this.cursor = cursor;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public String getCursor() {
        return cursor;
    }

    public void setCursor(String cursor) {
        this.cursor = cursor;
    }

    @Override
    public String toString() {
        return "ResponseInfo{" +
                "count=" + count +
                ", cursor='" + cursor + '\'' +
                '}';
    }
}
