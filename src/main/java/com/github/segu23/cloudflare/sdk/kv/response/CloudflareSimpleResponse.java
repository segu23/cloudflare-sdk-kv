package com.github.segu23.cloudflare.sdk.kv.response;

import com.github.segu23.cloudflare.sdk.kv.model.CloudflareError;
import com.github.segu23.cloudflare.sdk.kv.model.Message;
import com.google.gson.annotations.SerializedName;

import java.util.Arrays;

public class CloudflareSimpleResponse<T> {

    @SerializedName("errors")
    private CloudflareError[] errors;
    @SerializedName("messages")
    private Message[] messages;
    @SerializedName("result")
    private T result;
    @SerializedName("success")
    private boolean success;

    public CloudflareSimpleResponse(CloudflareError[] errors, Message[] messages, T result, boolean success) {
        this.errors = errors;
        this.messages = messages;
        this.result = result;
        this.success = success;
    }

    public CloudflareError[] getErrors() {
        return errors;
    }

    public void setErrors(CloudflareError[] errors) {
        this.errors = errors;
    }

    public Message[] getMessages() {
        return messages;
    }

    public void setMessages(Message[] messages) {
        this.messages = messages;
    }

    public T getResult() {
        return result;
    }

    public void setResult(T result) {
        this.result = result;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    @Override
    public String toString() {
        return "CloudflareSimpleResponse{" +
                "errors=" + Arrays.toString(errors) +
                ", messages=" + Arrays.toString(messages) +
                ", result=" + result +
                ", success=" + success +
                '}';
    }
}
