package com.github.segu23.cloudflare.sdk.kv.model;

import com.google.gson.annotations.SerializedName;

public class ResponsePaginationInfo {

    @SerializedName("count")
    private int count;
    @SerializedName("page")
    private int page;
    @SerializedName("per_page")
    private int perPage;
    @SerializedName("total_count")
    private int totalCount;

    public ResponsePaginationInfo(int count, int page, int perPage, int totalCount) {
        this.count = count;
        this.page = page;
        this.perPage = perPage;
        this.totalCount = totalCount;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getPerPage() {
        return perPage;
    }

    public void setPerPage(int perPage) {
        this.perPage = perPage;
    }

    public int getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(int totalCount) {
        this.totalCount = totalCount;
    }

    @Override
    public String toString() {
        return "ResponsePaginationInfo{" +
                "count=" + count +
                ", page=" + page +
                ", per_page=" + perPage +
                ", total_count=" + totalCount +
                '}';
    }
}