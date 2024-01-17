# cloudflare-sdk-kv

## Usage/Examples

### Including the sdk in your project
#### Maven
```xml
	<repository>
		<id>jitpack.io</id>
		<url>https://jitpack.io</url>
	</repository>
```
```xml
	<dependency>
		<groupId>com.github.segu23</groupId>
		<artifactId>cloudflare-sdk-kv</artifactId>
		<version>1.1</version>
	</dependency>
```
#### Gradle
```gradle
	dependencyResolutionManagement {
		repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
		repositories {
			mavenCentral()
			maven { url 'https://jitpack.io' }
		}
	}
```
```gradle
	dependencies {
	        implementation 'com.github.segu23:cloudflare-sdk-kv:1.0'
	}
```

### Initializing KV service
```java
IWorkerKVService workerKVService = CloudflareKVConfig.builder()
                .setAccountIdentifier("XXXXXXXXXX")
                .setAuthorizationToken("XXXXXXXXXX")
                .setApiKey("XXXXXXXXXX")
                .setApiEmail("XXXXXXXXXX")
                .build();
```

### List Namespaces
- [Cloudflare docs](https://developers.cloudflare.com/api/operations/workers-kv-namespace-list-namespaces)
```java
ListNamespacesResponse listNamespacesResponse = workerKVService.listNamespaces();
```

### Create a Namespace
- [Cloudflare docs](https://developers.cloudflare.com/api/operations/workers-kv-namespace-create-a-namespace)
```java
CreateNamespaceResponse createNamespaceResponse = workerKVService.createNamespace("namespace-title");
```

### Find Namespace by name
```java
Namespace namespace = workerKVService.findNamespaceByName("namespace-title");
``` 

### Remove a Namespace
- [Cloudflare docs](https://developers.cloudflare.com/api/operations/workers-kv-namespace-remove-a-namespace)
```java
RemoveNamespaceResponse removeNamespaceResponse = workerKVService.removeNamespace(namespace.getId());
```

### Rename a Namespace
- [Cloudflare docs](https://developers.cloudflare.com/api/operations/workers-kv-namespace-rename-a-namespace)
```java
RenameNamespaceResponse renameNamespaceResponse = workerKVService.renameNamespace(namespace.getId(), "new-namespace-title");
```

### Delete multiple key-value pairs
- [Cloudflare docs](https://developers.cloudflare.com/api/operations/workers-kv-namespace-delete-multiple-key-value-pairs)
```java
DeleteMultipleKeyValuePairsResponse deleteMultipleKeyValuePairsResponse = workerKVService.deleteMultipleKeyValuePairs(namespace.getId(), new String[]{"firstKey", "secondKey"});
```

### Write multiple key-value pairs
- [Cloudflare docs](https://developers.cloudflare.com/api/operations/workers-kv-namespace-write-multiple-key-value-pairs)
```java
WriteMultipleKeyValuePairsResponse writeMultipleKeyValuePairsResponse = workerKVService.writeMultipleKeyValuePairs(namespace.getId(), 
        new KeyValuePair[]{
                KeyValuePair.builder()
                        .key("firstKey")
                        .value("example firstKey value")
                        .metadata(Map.of(
                            "firstMetadata", "firstMetadata value", 
                            "secondMetadata", "secondMetadata value"
                        ))
                        .build(),
                KeyValuePair.builder()
                        .key("secondKey")
                        .value("example secondKey value")
                        .build()
        }
);
```

### List a Namespace's Keys
- [Cloudflare docs](https://developers.cloudflare.com/api/operations/workers-kv-namespace-list-a-namespace'-s-keys)
```java
ListNamespaceKeysResponse listNamespaceKeysResponse = workerKVService.listNamespaceKeys(namespace.getId());
```

### Read the metadata for a key
- [Cloudflare docs](https://developers.cloudflare.com/api/operations/workers-kv-namespace-read-the-metadata-for-a-key)
```java
ReadMetadataKeyResponse readMetadataKeyResponse = workerKVService.readMetadataKey(namespace.getId(), "firstKey");
```

### Delete key-value pair
- [Cloudflare docs](https://developers.cloudflare.com/api/operations/workers-kv-namespace-delete-key-value-pair)
```java
DeleteKeyValuePairResponse deleteKeyValuePairResponse = workerKVService.deleteKeyValuePair(namespace.getId(), "firstKey");
```

### Read key-value pair
- [Cloudflare docs](https://developers.cloudflare.com/api/operations/workers-kv-namespace-read-key-value-pair)
```java
String firstKeyValue = workerKVService.readKeyValuePair(namespace.getId(), "firstKey");
```

### Write key-value pair with metadata
- [Cloudflare docs](https://developers.cloudflare.com/api/operations/workers-kv-namespace-write-key-value-pair-with-metadata)
```java
WriteKeyValuePairWithMetadataResponse writeKeyValuePairWithMetadataResponse = workerKVService.writeKeyValuePairWithMetadata(namespace.getId(), 
    "firstKey", "firstKeyValue", 
    Map.of(
        "firstMetadata", "firstMetadata value", 
        "secondMetadata", "secondMetadata value"
    )
);
```
