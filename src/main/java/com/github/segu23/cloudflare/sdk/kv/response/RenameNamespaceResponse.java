package com.github.segu23.cloudflare.sdk.kv.response;

import com.github.segu23.cloudflare.sdk.kv.model.CloudflareError;
import com.github.segu23.cloudflare.sdk.kv.model.Message;

import java.util.Arrays;

public class RenameNamespaceResponse extends CloudflareSimpleResponse<Object> {

    public RenameNamespaceResponse(CloudflareError[] errors, Message[] messages, Object result, boolean success) {
        super(errors, messages, result, success);
    }

    @Override
    public String toString() {
        return "RenameNamespaceResponse{" +
                "errors=" + Arrays.toString(getErrors()) +
                ", messages=" + Arrays.toString(getMessages()) +
                ", result=" + getResult() +
                ", success=" + isSuccess() +
                "}";
    }
}
