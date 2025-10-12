package com.example.accountservice.response.feign;

import com.ecwid.consul.v1.Request;
import lombok.*;

import java.util.Collection;
import java.util.Map;

@Value
@Builder
public class Response<T> {

    int status;
    String reason;
    Map<String, Collection<String>> headers;
    Body body;
    Request request;

    public static Body body(){
        return body();
    }
}
