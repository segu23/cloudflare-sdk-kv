package com.github.segu23.cloudflare.sdk.kv.response;

import com.github.segu23.cloudflare.sdk.kv.model.CloudflareError;
import com.github.segu23.cloudflare.sdk.kv.model.Message;

import java.util.Arrays;
import java.util.Map;

public class ReadMetadataKeyResponse extends CloudflareSimpleResponse<Map<String, String>> {

    public ReadMetadataKeyResponse(CloudflareError[] errors, Message[] messages, Map<String, String> result, boolean success) {
        super(errors, messages, result, success);
    }

    @Override
    public String toString() {
        return "ReadMetadataKeyResponse{" +
                "errors=" + Arrays.toString(getErrors()) +
                ", messages=" + Arrays.toString(getMessages()) +
                ", result=" + getResult() +
                ", success=" + isSuccess() +
                "}";
    }
}
