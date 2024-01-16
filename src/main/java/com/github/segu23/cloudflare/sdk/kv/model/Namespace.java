package com.github.segu23.cloudflare.sdk.kv.model;

import lombok.Data;

@Data
public class Namespace {

    private String id;
    private boolean supports_url_encoding;
    private String title;
}
