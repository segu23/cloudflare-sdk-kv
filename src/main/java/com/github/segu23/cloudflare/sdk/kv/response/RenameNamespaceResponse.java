package com.github.segu23.cloudflare.sdk.kv.response;

import com.github.segu23.cloudflare.sdk.kv.model.CloudflareError;
import com.github.segu23.cloudflare.sdk.kv.model.Message;
import lombok.Data;

@Data
public class RenameNamespaceResponse {

    private CloudflareError[] errors;
    private Message[] messages;
    private Object result;
    private boolean success;
}
