package com.github.segu23.cloudflare.sdk.kv.model;

import com.google.gson.annotations.SerializedName;

public class CloudflareError {

    @SerializedName("code")
    private int code;
    @SerializedName("message")
    private String message;

    public CloudflareError(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public CloudflareError() {
    }

    public int getCode() {
        return code;
    }

    public CloudflareError setCode(int code) {
        this.code = code;
        return this;
    }

    public String getMessage() {
        return message;
    }

    public CloudflareError setMessage(String message) {
        this.message = message;
        return this;
    }

    @Override
    public String toString() {
        return "CloudflareError{" +
                "code=" + code +
                ", message='" + message + '\'' +
                '}';
    }
}
