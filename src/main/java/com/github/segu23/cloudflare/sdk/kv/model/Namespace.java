package com.github.segu23.cloudflare.sdk.kv.model;

import com.google.gson.annotations.SerializedName;

public class Namespace {

    @SerializedName("id")
    private String id;
    @SerializedName("supports_url_encoding")
    private boolean supportsUrlEncoding;
    @SerializedName("title")
    private String title;

    public Namespace(String id, boolean supportsUrlEncoding, String title) {
        this.id = id;
        this.supportsUrlEncoding = supportsUrlEncoding;
        this.title = title;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public boolean isSupportsUrlEncoding() {
        return supportsUrlEncoding;
    }

    public void setSupportsUrlEncoding(boolean supportsUrlEncoding) {
        this.supportsUrlEncoding = supportsUrlEncoding;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return "Namespace{" +
                "id='" + id + '\'' +
                ", supports_url_encoding=" + supportsUrlEncoding +
                ", title='" + title + '\'' +
                '}';
    }
}
