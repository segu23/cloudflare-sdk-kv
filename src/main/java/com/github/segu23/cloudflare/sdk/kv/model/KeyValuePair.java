package com.github.segu23.cloudflare.sdk.kv.model;

import com.google.gson.annotations.SerializedName;

import java.util.Map;

public class KeyValuePair {

    @SerializedName("base64")
    private boolean base64;
    @SerializedName("expiration")
    private long expiration;
    @SerializedName("expiration_ttl")
    private long expirationTtl;
    @SerializedName("key")
    private String key;
    @SerializedName("metadata")
    private Map<String, String> metadata;
    @SerializedName("value")
    private String value;

    public KeyValuePair(boolean base64, long expiration, long expirationTtl, String key, Map<String, String> metadata, String value) {
        this.base64 = base64;
        this.expiration = expiration;
        this.expirationTtl = expirationTtl;
        this.key = key;
        this.metadata = metadata;
        this.value = value;
    }

    public boolean isBase64() {
        return base64;
    }

    public KeyValuePair setBase64(boolean base64) {
        this.base64 = base64;
        return this;
    }

    public long getExpiration() {
        return expiration;
    }

    public KeyValuePair setExpiration(long expiration) {
        this.expiration = expiration;
        return this;
    }

    public long getExpirationTtl() {
        return expirationTtl;
    }

    public KeyValuePair setExpirationTtl(long expirationTtl) {
        this.expirationTtl = expirationTtl;
        return this;
    }

    public String getKey() {
        return key;
    }

    public KeyValuePair setKey(String key) {
        this.key = key;
        return this;
    }

    public Map<String, String> getMetadata() {
        return metadata;
    }

    public KeyValuePair setMetadata(Map<String, String> metadata) {
        this.metadata = metadata;
        return this;
    }

    public String getValue() {
        return value;
    }

    public KeyValuePair setValue(String value) {
        this.value = value;
        return this;
    }

    @Override
    public String toString() {
        return "KeyValuePair{" +
                "base64=" + base64 +
                ", expiration=" + expiration +
                ", expiration_ttl=" + expirationTtl +
                ", key='" + key + '\'' +
                ", metadata=" + metadata +
                ", value='" + value + '\'' +
                '}';
    }
}
