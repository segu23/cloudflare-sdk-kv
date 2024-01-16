package com.github.segu23.cloudflare.sdk.kv.model;

import lombok.Data;

@Data
public class ResponsePaginationInfo {

    private int count;
    private int page;
    private int per_page;
    private int total_count;
}