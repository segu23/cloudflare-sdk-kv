package com.github.segu23.cloudflare.sdk.kv.exception;

import com.github.segu23.cloudflare.sdk.kv.response.CloudflareExceptionResponse;

import java.util.Arrays;

public class CloudflareException extends RuntimeException {

    private final CloudflareExceptionResponse cloudflareExceptionResponse;

    public CloudflareException(CloudflareExceptionResponse cloudflareExceptionResponse) {
        super(Arrays.toString(cloudflareExceptionResponse.getErrors()));
        this.cloudflareExceptionResponse = cloudflareExceptionResponse;
    }

    public CloudflareExceptionResponse getCloudflareExceptionResponse() {
        return cloudflareExceptionResponse;
    }
}
