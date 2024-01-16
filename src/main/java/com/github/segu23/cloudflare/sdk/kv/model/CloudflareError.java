package com.github.segu23.cloudflare.sdk.kv.model;

import lombok.Data;

@Data
public class CloudflareError {

    private int code;
    private String message;
}
