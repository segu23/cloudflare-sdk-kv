package com.github.segu23.cloudflare.sdk.kv;

import com.github.segu23.cloudflare.sdk.kv.service.IWorkerKVService;
import com.github.segu23.cloudflare.sdk.kv.service.impl.WorkerKVServiceImpl;
import lombok.Getter;

import java.util.HashMap;
import java.util.Map;

public class CloudflareKVConfig {

    @Getter
    private final Map<String, String> headers = new HashMap<>();
    private String cloudflareClientUrl = "https://api.cloudflare.com/client/v4";
    private String accountIdentifier;
    private String authorizationToken;
    private String apiEmail;
    private String apiKey;

    public static CloudflareKVConfig builder() {
        return new CloudflareKVConfig();
    }

    public CloudflareKVConfig setCloudflareClientUrl(String cloudflareClientUrl) {
        this.cloudflareClientUrl = cloudflareClientUrl;
        return this;
    }

    public CloudflareKVConfig setAccountIdentifier(String accountIdentifier) {
        this.accountIdentifier = accountIdentifier;
        return this;
    }

    public CloudflareKVConfig setAuthorizationToken(String authorizationToken) {
        this.authorizationToken = authorizationToken;
        return this;
    }

    public CloudflareKVConfig setApiKey(String apiKey) {
        this.apiKey = apiKey;
        return this;
    }

    public CloudflareKVConfig setApiEmail(String apiEmail) {
        this.apiEmail = apiEmail;
        return this;
    }

    public IWorkerKVService build() {
        if (authorizationToken != null) headers.put("Authorization", String.format("Bearer %s", authorizationToken));
        if (apiEmail != null) headers.put("X-Auth-Email", apiEmail);
        if (apiKey != null) headers.put("X-Auth-Key", apiKey);

        return new WorkerKVServiceImpl(this);
    }

    public String getBaseURL() {
        return String.format("%s/accounts/%s/storage/kv/namespaces", cloudflareClientUrl, accountIdentifier);
    }

    public String getAuthorizationToken() {
        return String.format("Bearer %s", authorizationToken);
    }
}
