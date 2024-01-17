package com.github.segu23.cloudflare.sdk.kv.response;

import com.github.segu23.cloudflare.sdk.kv.model.CloudflareError;
import com.github.segu23.cloudflare.sdk.kv.model.Message;
import com.github.segu23.cloudflare.sdk.kv.model.Namespace;

import java.util.Arrays;

public class CreateNamespaceResponse extends CloudflareSimpleResponse<Namespace> {

    public CreateNamespaceResponse(CloudflareError[] errors, Message[] messages, Namespace result, boolean success) {
        super(errors, messages, result, success);
    }

    @Override
    public String toString() {
        return "CreateNamespaceResponse{" +
                "errors=" + Arrays.toString(getErrors()) +
                ", messages=" + Arrays.toString(getMessages()) +
                ", result=" + getResult() +
                ", success=" + isSuccess() +
                "}";
    }
}
