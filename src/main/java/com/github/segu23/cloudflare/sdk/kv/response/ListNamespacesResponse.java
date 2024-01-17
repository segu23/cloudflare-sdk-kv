package com.github.segu23.cloudflare.sdk.kv.response;

import com.github.segu23.cloudflare.sdk.kv.model.CloudflareError;
import com.github.segu23.cloudflare.sdk.kv.model.Message;
import com.github.segu23.cloudflare.sdk.kv.model.Namespace;
import com.github.segu23.cloudflare.sdk.kv.model.ResponsePaginationInfo;
import com.google.gson.annotations.SerializedName;

import java.util.Arrays;

public class ListNamespacesResponse extends CloudflareSimpleResponse<Namespace[]> {

    @SerializedName("result_info")
    private ResponsePaginationInfo resultInfo;

    public ListNamespacesResponse(CloudflareError[] errors, Message[] messages, Namespace[] result, boolean success, ResponsePaginationInfo resultInfo) {
        super(errors, messages, result, success);
        this.resultInfo = resultInfo;
    }

    public ResponsePaginationInfo getResultInfo() {
        return resultInfo;
    }

    public void setResultInfo(ResponsePaginationInfo resultInfo) {
        this.resultInfo = resultInfo;
    }

    @Override
    public String toString() {
        return "ListNamespacesResponse{" +
                "errors=" + Arrays.toString(getErrors()) +
                ", messages=" + Arrays.toString(getMessages()) +
                ", result=" + Arrays.toString(getResult()) +
                ", success=" + isSuccess() +
                ", result_info=" + resultInfo +
                '}';
    }
}
