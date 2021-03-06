package com.spheremall.core.makers;

import com.google.gson.Gson;
import com.spheremall.core.api.response.ElasticSearchListResponse;
import com.spheremall.core.api.response.ElasticSearchResponse;
import com.spheremall.core.entities.Response;

import java.util.HashMap;
import java.util.List;

public class ESResponseMaker implements Maker<ElasticSearchResponse> {

    @Override
    public Response<ElasticSearchResponse> makeSingle(String response) {
        Gson gson = new Gson();
        ElasticSearchResponse searchResponse = gson.fromJson(response, ElasticSearchResponse.class);
        return new Response<>(searchResponse, new HashMap<>());
    }

    @Override
    public Response<List<ElasticSearchResponse>> makeAsList(String response) {
        Gson gson = new Gson();
        ElasticSearchListResponse searchResponse = gson.fromJson(response, ElasticSearchListResponse.class);
        return new Response<>(searchResponse.responses, new HashMap<>());
    }
}
