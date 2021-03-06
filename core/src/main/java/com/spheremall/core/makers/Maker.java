package com.spheremall.core.makers;

import com.spheremall.core.entities.Response;

import java.util.List;

public interface Maker<T> extends SingleMaker<T> {
    Response<List<T>> makeAsList(String response);
}
