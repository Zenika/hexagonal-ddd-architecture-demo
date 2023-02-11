package com.shipco.common;

import java.util.function.Function;

public class RestClient {

    private final String url;
    private final Function<String, String> stub;

    public RestClient(String url, Function<String, String> stub) {
        this.url = url;
        this.stub = stub;
    }

    public String post(String path, String pathParameterName, String pathParameterValue) {
        return stub.apply(pathParameterValue);
    }

    public String get(String path, String pathParameterName, String pathParameterValue) {
        return stub.apply(pathParameterValue);
    }

}
