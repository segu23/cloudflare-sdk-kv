package com.github.segu23.cloudflare.sdk.kv.response;

import com.github.segu23.cloudflare.sdk.kv.model.CloudflareError;
import com.github.segu23.cloudflare.sdk.kv.model.Message;
import com.github.segu23.cloudflare.sdk.kv.model.ResponseInfo;
import lombok.Data;

@Data
public class ListNamespaceKeysResponse {

    private CloudflareError[] errors;
    private Message[] messages;
    private KeyDataResponse[] result;
    private boolean success;
    private ResponseInfo result_info;
}
