package com.github.segu23.cloudflare.sdk.kv.response;

import com.github.segu23.cloudflare.sdk.kv.model.CloudflareError;
import com.github.segu23.cloudflare.sdk.kv.model.Message;
import com.github.segu23.cloudflare.sdk.kv.model.Namespace;
import com.github.segu23.cloudflare.sdk.kv.model.ResponsePaginationInfo;
import lombok.Data;

@Data
public class ListNamespacesResponse {

    private CloudflareError[] errors;
    private Message[] messages;
    private Namespace[] result;
    private boolean success;
    private ResponsePaginationInfo result_info;
}
