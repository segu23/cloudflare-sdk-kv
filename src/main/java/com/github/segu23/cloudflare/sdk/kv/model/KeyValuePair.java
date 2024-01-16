package com.github.segu23.cloudflare.sdk.kv.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Map;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class KeyValuePair {

    private boolean base64;
    private long expiration;
    private long expiration_ttl;
    private String key;
    private Map<String, String> metadata;
    private String value;
}
