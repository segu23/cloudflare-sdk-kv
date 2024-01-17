package com.github.segu23.cloudflare.sdk.kv.response;

import com.github.segu23.cloudflare.sdk.kv.model.CloudflareError;
import com.github.segu23.cloudflare.sdk.kv.model.Message;
import com.github.segu23.cloudflare.sdk.kv.model.ResponseInfo;
import com.google.gson.annotations.SerializedName;

import java.util.Arrays;

public class ListNamespaceKeysResponse extends CloudflareSimpleResponse<KeyDataResponse[]> {

    @SerializedName("result_info")
    private ResponseInfo resultInfo;

    public ListNamespaceKeysResponse(CloudflareError[] errors, Message[] messages, KeyDataResponse[] result, boolean success, ResponseInfo resultInfo) {
        super(errors, messages, result, success);
        this.resultInfo = resultInfo;
    }

    @Override
    public String toString() {
        return "ListNamespaceKeysResponse{" +
                "errors=" + Arrays.toString(getErrors()) +
                ", messages=" + Arrays.toString(getMessages()) +
                ", result=" + Arrays.toString(getResult()) +
                ", success=" + isSuccess() +
                ", result_info=" + resultInfo +
                '}';
    }
}
