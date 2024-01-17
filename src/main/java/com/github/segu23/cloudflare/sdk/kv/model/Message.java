package com.github.segu23.cloudflare.sdk.kv.model;

import com.google.gson.annotations.SerializedName;

public class Message {

    @SerializedName("code")
    private int code;
    @SerializedName("message")
    private String message;

    public Message(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "Message{" +
                "code=" + code +
                ", message='" + message + '\'' +
                '}';
    }
}
