package com.github.segu23.cloudflare.sdk.kv.model;

public class HttpResponse {

    private int status;
    private String body;

    public HttpResponse(int status, String body) {
        this.status = status;
        this.body = body;
    }

    public HttpResponse() {
    }

    public int getStatus() {
        return status;
    }

    public HttpResponse setStatus(int status) {
        this.status = status;
        return this;
    }

    public String getBody() {
        return body;
    }

    public HttpResponse setBody(String body) {
        this.body = body;
        return this;
    }

    @Override
    public String toString() {
        return "HttpResponse{" +
                "status=" + status +
                ", body='" + body + '\'' +
                '}';
    }
}
