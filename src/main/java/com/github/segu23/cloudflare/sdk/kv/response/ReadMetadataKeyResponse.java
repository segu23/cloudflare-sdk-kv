package com.github.segu23.cloudflare.sdk.kv.response;

import com.github.segu23.cloudflare.sdk.kv.model.CloudflareError;
import com.github.segu23.cloudflare.sdk.kv.model.Message;
import lombok.Data;

import java.util.Map;

@Data
public class ReadMetadataKeyResponse {

    private CloudflareError[] errors;
    private Message[] messages;
    private Map<String, String> result;
    private boolean success;
}
