package com.github.segu23.cloudflare.sdk.kv.response;

import com.github.segu23.cloudflare.sdk.kv.model.CloudflareError;
import com.github.segu23.cloudflare.sdk.kv.model.Message;

import java.util.Arrays;

public class WriteKeyValuePairWithMetadataResponse extends CloudflareSimpleResponse<Object> {

    public WriteKeyValuePairWithMetadataResponse(CloudflareError[] errors, Message[] messages, Object result, boolean success) {
        super(errors, messages, result, success);
    }

    @Override
    public String toString() {
        return "WriteKeyValuePairWithMetadataResponse{" +
                "errors=" + Arrays.toString(getErrors()) +
                ", messages=" + Arrays.toString(getMessages()) +
                ", result=" + getResult() +
                ", success=" + isSuccess() +
                "}";
    }
}
