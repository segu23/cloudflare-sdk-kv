package com.github.segu23.cloudflare.sdk.kv.response;

import com.github.segu23.cloudflare.sdk.kv.model.CloudflareError;
import com.github.segu23.cloudflare.sdk.kv.model.Message;
import com.github.segu23.cloudflare.sdk.kv.model.Namespace;

import java.util.Arrays;

public class CloudflareExceptionResponse {

    private CloudflareError[] errors;
    private Message[] messages;
    private Namespace result;
    private boolean success;

    public CloudflareExceptionResponse(CloudflareError[] errors, Message[] messages, Namespace result, boolean success) {
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

    public Namespace getResult() {
        return result;
    }

    public void setResult(Namespace result) {
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
        return "CloudflareExceptionResponse{" +
                "errors=" + Arrays.toString(errors) +
                ", messages=" + Arrays.toString(messages) +
                ", result=" + result +
                ", success=" + success +
                '}';
    }
}
