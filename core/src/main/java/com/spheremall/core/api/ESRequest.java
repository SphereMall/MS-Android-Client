package com.spheremall.core.api;

import com.spheremall.core.SMClient;
import com.spheremall.core.api.configuration.Method;
import com.spheremall.core.api.response.ResponseMonada;
import com.spheremall.core.resources.BaseResource;

import org.apache.http.HttpEntity;
import org.apache.http.HttpHost;
import org.apache.http.entity.ContentType;
import org.apache.http.nio.entity.NStringEntity;
import org.apache.http.util.EntityUtils;
import org.elasticsearch.client.Response;
import org.elasticsearch.client.RestClient;

import java.io.IOException;
import java.util.HashMap;

public class ESRequest implements BaseRequest {

    private static final String BODY = "body";
    private SMClient client;
    private BaseResource resource;

    public ESRequest(SMClient client, BaseResource resource) {
        this.client = client;
        this.resource = resource;
    }

    @Override
    public ResponseMonada handle(Method method, String uriAppend, HashMap<String, String> queryParams) throws IOException {

        HttpEntity entity = new NStringEntity(queryParams.get(BODY), ContentType.APPLICATION_JSON);

        RestClient restClient = getRestClient();

        StringBuilder urlBuilder = getURI(uriAppend);

        Response response = restClient.performRequest(
                method.name(),
                urlBuilder.toString(),
                client.getHeaders(),
                entity
        );
        String responseString = EntityUtils.toString(response.getEntity());
        restClient.close();
        return new ResponseMonada(responseString);
    }

    private RestClient getRestClient() {

        return RestClient
                .builder(HttpHost.create(client.getGatewayUrl()))
                .build();
    }

    private StringBuilder getURI(String uriAppend) {
        StringBuilder urlBuilder = new StringBuilder();
        urlBuilder.append("/");
        urlBuilder.append(client.getVersion());
        urlBuilder.append("/");
        urlBuilder.append(resource.getURI());
        if (uriAppend != null && !uriAppend.isEmpty()) {
            urlBuilder.append("/");
            urlBuilder.append(uriAppend);
        }
        return urlBuilder;
    }
}
