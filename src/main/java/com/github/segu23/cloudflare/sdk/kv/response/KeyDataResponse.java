package com.github.segu23.cloudflare.sdk.kv.response;

import lombok.Data;

import java.util.Map;

@Data
public class KeyDataResponse {

    private long expiration;
    private Map<String, String> metadata;
    private String name;
}
