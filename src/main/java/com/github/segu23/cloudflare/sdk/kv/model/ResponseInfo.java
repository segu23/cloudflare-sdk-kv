package com.github.segu23.cloudflare.sdk.kv.model;

import lombok.Data;

@Data
public class ResponseInfo {

    private int count;
    private String cursor;
}
