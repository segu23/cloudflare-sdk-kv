package com.github.segu23.cloudflare.sdk.kv.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Builder
@Data
@NoArgsConstructor
public class HttpResponse {

    private int status;
    private String body;
}
