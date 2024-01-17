package com.github.segu23.cloudflare.sdk.kv.response;

import com.google.gson.annotations.SerializedName;

import java.util.Map;

public class KeyDataResponse {

    @SerializedName("expiration")
    private long expiration;
    @SerializedName("metadata")
    private Map<String, String> metadata;
    @SerializedName("name")
    private String name;

    public KeyDataResponse(long expiration, Map<String, String> metadata, String name) {
        this.expiration = expiration;
        this.metadata = metadata;
        this.name = name;
    }

    public long getExpiration() {
        return expiration;
    }

    public void setExpiration(long expiration) {
        this.expiration = expiration;
    }

    public Map<String, String> getMetadata() {
        return metadata;
    }

    public void setMetadata(Map<String, String> metadata) {
        this.metadata = metadata;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "KeyDataResponse{" +
                "expiration=" + expiration +
                ", metadata=" + metadata +
                ", name='" + name + '\'' +
                '}';
    }
}
