package com.github.segu23.cloudflare.sdk.kv.service;

import com.github.segu23.cloudflare.sdk.kv.exception.CloudflareException;
import com.github.segu23.cloudflare.sdk.kv.model.KeyValuePair;
import com.github.segu23.cloudflare.sdk.kv.model.Namespace;
import com.github.segu23.cloudflare.sdk.kv.response.*;

import java.util.Map;

public interface IWorkerKVService {

    ListNamespacesResponse listNamespaces() throws CloudflareException;

    CreateNamespaceResponse createNamespace(String title) throws CloudflareException;

    RemoveNamespaceResponse removeNamespace(String namespaceIdentifier) throws CloudflareException;

    RenameNamespaceResponse renameNamespace(String namespaceIdentifier, String newNamespaceTitle) throws CloudflareException;

    DeleteMultipleKeyValuePairsResponse deleteMultipleKeyValuePairs(String namespaceIdentifier, String[] keys) throws CloudflareException;

    WriteMultipleKeyValuePairsResponse writeMultipleKeyValuePairs(String namespaceIdentifier, KeyValuePair[] keyValuePairs) throws CloudflareException;

    // todo add query parameters
    ListNamespaceKeysResponse listNamespaceKeys(String namespaceIdentifier) throws CloudflareException;

    ReadMetadataKeyResponse readMetadataKey(String namespaceIdentifier, String keyName) throws CloudflareException;

    DeleteKeyValuePairResponse deleteKeyValuePair(String namespaceIdentifier, String keyName) throws CloudflareException;

    String readKeyValuePair(String namespaceIdentifier, String keyName) throws CloudflareException;

    WriteKeyValuePairWithMetadataResponse writeKeyValuePairWithMetadata(String namespaceIdentifier, String keyName, String value, Map<String, String> metadata) throws CloudflareException;

    Namespace findNamespaceByName(String namespaceName) throws CloudflareException;
}

