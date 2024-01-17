package com.github.segu23.cloudflare.sdk.kv.service.impl;

import com.github.segu23.cloudflare.sdk.kv.CloudflareKVConfig;
import com.github.segu23.cloudflare.sdk.kv.exception.CloudflareException;
import com.github.segu23.cloudflare.sdk.kv.model.HttpResponse;
import com.github.segu23.cloudflare.sdk.kv.model.KeyValuePair;
import com.github.segu23.cloudflare.sdk.kv.model.Namespace;
import com.github.segu23.cloudflare.sdk.kv.response.*;
import com.github.segu23.cloudflare.sdk.kv.service.IWorkerKVService;
import com.github.segu23.cloudflare.sdk.kv.util.HttpUtil;
import com.google.gson.Gson;
import org.apache.http.entity.mime.MultipartEntityBuilder;

import java.util.Arrays;
import java.util.Map;

public class WorkerKVServiceImpl implements IWorkerKVService {

    private final Gson gson = new Gson();
    private final CloudflareKVConfig cloudflareKVConfig;

    public WorkerKVServiceImpl(CloudflareKVConfig cloudflareKVConfig) {
        this.cloudflareKVConfig = cloudflareKVConfig;
    }

    @Override
    public ListNamespacesResponse listNamespaces() throws CloudflareException {
        HttpResponse httpResponse = HttpUtil.getData(
                cloudflareKVConfig.getBaseURL() + "",
                HttpUtil.APPLICATION_JSON,
                cloudflareKVConfig.getHeaders()
        );

        if (httpResponse != null && httpResponse.getStatus() == 200) {
            return gson.fromJson(httpResponse.getBody(), ListNamespacesResponse.class);
        }

        throw new CloudflareException(gson.fromJson(httpResponse.getBody(), CloudflareExceptionResponse.class));
    }

    @Override
    public CreateNamespaceResponse createNamespace(String title) throws CloudflareException {
        HttpResponse httpResponse = HttpUtil.sendData(
                cloudflareKVConfig.getBaseURL() + "",
                gson.toJson(Map.of("title", title)),
                "POST",
                HttpUtil.APPLICATION_JSON,
                cloudflareKVConfig.getHeaders()
        );

        if (httpResponse != null && httpResponse.getStatus() == 200) {
            return gson.fromJson(httpResponse.getBody(), CreateNamespaceResponse.class);
        }

        throw new CloudflareException(gson.fromJson(httpResponse.getBody(), CloudflareExceptionResponse.class));
    }

    @Override
    public RemoveNamespaceResponse removeNamespace(String namespaceIdentifier) throws CloudflareException {
        cloudflareKVConfig.getHeaders().forEach((s, s2) -> System.out.println(s + " -> " + s2));
        HttpResponse httpResponse = HttpUtil.sendData(
                String.format(cloudflareKVConfig.getBaseURL() + "/%s", namespaceIdentifier),
                "",
                "DELETE",
                HttpUtil.APPLICATION_JSON,
                cloudflareKVConfig.getHeaders()
        );

        if (httpResponse != null && httpResponse.getStatus() == 200) {
            return gson.fromJson(httpResponse.getBody(), RemoveNamespaceResponse.class);
        }

        throw new CloudflareException(gson.fromJson(httpResponse.getBody(), CloudflareExceptionResponse.class));
    }

    @Override
    public RenameNamespaceResponse renameNamespace(String namespaceIdentifier, String newNamespaceTitle) throws CloudflareException {
        HttpResponse httpResponse = HttpUtil.sendData(
                String.format(cloudflareKVConfig.getBaseURL() + "/%s", namespaceIdentifier),
                gson.toJson(Map.of("title", newNamespaceTitle)),
                "PUT",
                HttpUtil.APPLICATION_JSON,
                cloudflareKVConfig.getHeaders()
        );

        if (httpResponse != null && httpResponse.getStatus() == 200) {
            return gson.fromJson(httpResponse.getBody(), RenameNamespaceResponse.class);
        }

        throw new CloudflareException(gson.fromJson(httpResponse.getBody(), CloudflareExceptionResponse.class));
    }

    @Override
    public DeleteMultipleKeyValuePairsResponse deleteMultipleKeyValuePairs(String namespaceIdentifier, String[] keys) throws CloudflareException {
        HttpResponse httpResponse = HttpUtil.sendData(
                String.format(cloudflareKVConfig.getBaseURL() + "/%s/bulk", namespaceIdentifier),
                gson.toJson(keys),
                "DELETE",
                HttpUtil.APPLICATION_JSON,
                cloudflareKVConfig.getHeaders()
        );

        if (httpResponse != null && httpResponse.getStatus() == 200) {
            return gson.fromJson(httpResponse.getBody(), DeleteMultipleKeyValuePairsResponse.class);
        }

        throw new CloudflareException(gson.fromJson(httpResponse.getBody(), CloudflareExceptionResponse.class));
    }

    @Override
    public WriteMultipleKeyValuePairsResponse writeMultipleKeyValuePairs(String namespaceIdentifier, KeyValuePair[] keyValuePairs) throws CloudflareException {
        HttpResponse httpResponse = HttpUtil.sendData(
                String.format(cloudflareKVConfig.getBaseURL() + "/%s/bulk", namespaceIdentifier),
                gson.toJson(keyValuePairs),
                "PUT",
                HttpUtil.APPLICATION_JSON,
                cloudflareKVConfig.getHeaders()
        );

        if (httpResponse != null && httpResponse.getStatus() == 200) {
            return gson.fromJson(httpResponse.getBody(), WriteMultipleKeyValuePairsResponse.class);
        }

        throw new CloudflareException(gson.fromJson(httpResponse.getBody(), CloudflareExceptionResponse.class));
    }

    @Override
    public ListNamespaceKeysResponse listNamespaceKeys(String namespaceIdentifier) throws CloudflareException {
        HttpResponse httpResponse = HttpUtil.getData(
                String.format(cloudflareKVConfig.getBaseURL() + "/%s/keys", namespaceIdentifier),
                HttpUtil.APPLICATION_JSON,
                cloudflareKVConfig.getHeaders()
        );

        if (httpResponse != null && httpResponse.getStatus() == 200) {
            return gson.fromJson(httpResponse.getBody(), ListNamespaceKeysResponse.class);
        }

        throw new CloudflareException(gson.fromJson(httpResponse.getBody(), CloudflareExceptionResponse.class));
    }

    @Override
    public ReadMetadataKeyResponse readMetadataKey(String namespaceIdentifier, String keyName) throws CloudflareException {
        HttpResponse httpResponse = HttpUtil.getData(
                String.format(cloudflareKVConfig.getBaseURL() + "/%s/metadata/%s", namespaceIdentifier, keyName),
                HttpUtil.APPLICATION_JSON,
                cloudflareKVConfig.getHeaders()
        );

        if (httpResponse != null && httpResponse.getStatus() == 200) {
            return gson.fromJson(httpResponse.getBody(), ReadMetadataKeyResponse.class);
        }

        throw new CloudflareException(gson.fromJson(httpResponse.getBody(), CloudflareExceptionResponse.class));
    }

    @Override
    public DeleteKeyValuePairResponse deleteKeyValuePair(String namespaceIdentifier, String keyName) throws CloudflareException {
        HttpResponse httpResponse = HttpUtil.sendData(
                String.format(cloudflareKVConfig.getBaseURL() + "/%s/values/%s", namespaceIdentifier, keyName),
                "",
                "DELETE",
                HttpUtil.APPLICATION_JSON,
                cloudflareKVConfig.getHeaders()
        );

        if (httpResponse != null && httpResponse.getStatus() == 200) {
            return gson.fromJson(httpResponse.getBody(), DeleteKeyValuePairResponse.class);
        }

        throw new CloudflareException(gson.fromJson(httpResponse.getBody(), CloudflareExceptionResponse.class));
    }

    @Override
    public String readKeyValuePair(String namespaceIdentifier, String keyName) throws CloudflareException {
        HttpResponse httpResponse = HttpUtil.getData(
                String.format(cloudflareKVConfig.getBaseURL() + "/%s/values/%s", namespaceIdentifier, keyName),
                HttpUtil.APPLICATION_JSON,
                cloudflareKVConfig.getHeaders()
        );

        if (httpResponse != null && httpResponse.getStatus() == 200) {
            return httpResponse.getBody();
        }

        throw new CloudflareException(gson.fromJson(httpResponse.getBody(), CloudflareExceptionResponse.class));
    }

    @Override
    public WriteKeyValuePairWithMetadataResponse writeKeyValuePairWithMetadata(String namespaceIdentifier, String keyName, String value, Map<String, String> metadata) throws CloudflareException {
        HttpResponse httpResponse = HttpUtil.sendFormPost(
                String.format(cloudflareKVConfig.getBaseURL() + "/%s/values/%s", namespaceIdentifier, keyName),
                cloudflareKVConfig.getHeaders(),
                MultipartEntityBuilder.create()
                        .addTextBody("metadata", gson.toJson(metadata))
                        .addTextBody("value", value)
                        .build()
        );

        if (httpResponse != null && httpResponse.getStatus() == 200) {
            return gson.fromJson(httpResponse.getBody(), WriteKeyValuePairWithMetadataResponse.class);
        }

        throw new CloudflareException(gson.fromJson(httpResponse.getBody(), CloudflareExceptionResponse.class));
    }

    @Override
    public Namespace findNamespaceByName(String namespaceName) throws CloudflareException {
        ListNamespacesResponse listNamespacesResponse = listNamespaces();
        return Arrays.stream(listNamespacesResponse.getResult()).filter(namespace -> namespace.getTitle().equals(namespaceName)).findFirst().orElse(null);
    }
}