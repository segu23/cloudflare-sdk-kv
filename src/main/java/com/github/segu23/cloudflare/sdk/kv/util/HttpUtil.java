package com.github.segu23.cloudflare.sdk.kv.util;

import com.github.segu23.cloudflare.sdk.kv.model.HttpResponse;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Map;

public class HttpUtil {

    public static String APPLICATION_JSON = "application/json";

    public static HttpResponse sendData(String targetURL, String bodyContent, String requestMethod, String contentType, Map<String, String> headers) {
        HttpURLConnection connection = null;

        try {
            URL url = new URL(targetURL);
            connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod(requestMethod);
            connection.setRequestProperty("Content-Type", contentType);
            if (headers != null) {
                for (Map.Entry<String, String> entry : headers.entrySet()) {
                    connection.setRequestProperty(entry.getKey(), entry.getValue());
                }
            }

            connection.setDoOutput(true);

            DataOutputStream wr = new DataOutputStream(
                    connection.getOutputStream());
            wr.writeBytes(bodyContent);
            wr.close();

            String response = extractTextFromInputStream(connection.getInputStream());

            return new HttpResponse()
                    .setBody(response)
                    .setStatus(connection.getResponseCode());
        } catch (Exception e) {
            String response = extractTextFromInputStream(connection.getErrorStream());
            try {
                return new HttpResponse()
                        .setBody(response)
                        .setStatus(connection.getResponseCode());
            } catch (Exception exception) {
                return new HttpResponse();
            }
        } finally {
            if (connection != null) {
                connection.disconnect();
            }
        }
    }

    public static HttpResponse getData(String targetURL, String contentType, Map<String, String> headers) {
        HttpURLConnection connection = null;

        try {
            URL url = new URL(targetURL);
            connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            connection.setRequestProperty("Content-Type", contentType);
            if (headers != null) {
                for (Map.Entry<String, String> entry : headers.entrySet()) {
                    connection.setRequestProperty(entry.getKey(), entry.getValue());
                }
            }

            String response = extractTextFromInputStream(connection.getInputStream());

            return new HttpResponse()
                    .setBody(response)
                    .setStatus(connection.getResponseCode());
        } catch (Exception e) {
            String response = extractTextFromInputStream(connection.getErrorStream());
            try {
                return new HttpResponse()
                        .setBody(response)
                        .setStatus(connection.getResponseCode());
            } catch (Exception exception) {
                return new HttpResponse();
            }
        } finally {
            if (connection != null) {
                connection.disconnect();
            }
        }
    }

    private static String extractTextFromInputStream(InputStream inputStream) {
        try {
            BufferedReader rd = new BufferedReader(new InputStreamReader(inputStream));
            StringBuilder response = new StringBuilder();
            String line;

            while ((line = rd.readLine()) != null) {
                response.append(line);
                response.append('\n');
            }

            rd.close();

            return response.toString();
        } catch (Exception e) {
            return "";
        }
    }

    public static HttpResponse sendFormPost(String targetURL, Map<String, String> headers, HttpEntity entity) {
        try (CloseableHttpClient connection = HttpClients.createDefault()) {
            HttpPut httpPost = new HttpPut(targetURL);

            httpPost.setEntity(entity);
            if (headers != null) {
                for (Map.Entry<String, String> entry : headers.entrySet()) {
                    httpPost.setHeader(entry.getKey(), entry.getValue());
                }
            }

            org.apache.http.HttpResponse httpResponse = connection.execute(httpPost);

            String response = extractTextFromInputStream(httpResponse.getEntity().getContent());

            return new HttpResponse()
                    .setBody(response)
                    .setStatus(httpResponse.getStatusLine().getStatusCode());
        } catch (Exception e) {
            return new HttpResponse();
        }
    }
}
