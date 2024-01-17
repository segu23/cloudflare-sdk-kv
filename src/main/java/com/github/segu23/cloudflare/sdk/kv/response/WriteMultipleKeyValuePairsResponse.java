package com.github.segu23.cloudflare.sdk.kv.response;

import com.github.segu23.cloudflare.sdk.kv.model.CloudflareError;
import com.github.segu23.cloudflare.sdk.kv.model.Message;

import java.util.Arrays;

public class WriteMultipleKeyValuePairsResponse extends CloudflareSimpleResponse<Object> {

    public WriteMultipleKeyValuePairsResponse(CloudflareError[] errors, Message[] messages, Object result, boolean success) {
        super(errors, messages, result, success);
    }

    @Override
    public String toString() {
        return "WriteMultipleKeyValuePairsResponse{" +
                "errors=" + Arrays.toString(getErrors()) +
                ", messages=" + Arrays.toString(getMessages()) +
                ", result=" + getResult() +
                ", success=" + isSuccess() +
                "}";
    }
}
