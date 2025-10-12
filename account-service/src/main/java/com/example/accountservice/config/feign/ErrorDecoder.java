package com.example.accountservice.config.feign;

import com.example.accountservice.response.feign.Response;

public interface ErrorDecoder {

    Exception decode(String methodKey, Response response);
}
