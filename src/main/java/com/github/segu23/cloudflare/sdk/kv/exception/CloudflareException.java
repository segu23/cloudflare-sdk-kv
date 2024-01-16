package com.github.segu23.cloudflare.sdk.kv.exception;

import com.github.segu23.cloudflare.sdk.kv.response.CloudflareExceptionResponse;
import lombok.Getter;

import java.util.Arrays;

@Getter
public class CloudflareException extends RuntimeException {

    private final CloudflareExceptionResponse cloudflareExceptionResponse;

    public CloudflareException(CloudflareExceptionResponse cloudflareExceptionResponse) {
        super(Arrays.toString(cloudflareExceptionResponse.getErrors()));
        this.cloudflareExceptionResponse = cloudflareExceptionResponse;
    }
}
