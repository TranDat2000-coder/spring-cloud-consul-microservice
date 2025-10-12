//package com.example.accountservice.config.feign;
//
//import com.example.accountservice.common.ErrorCode;
//import com.example.accountservice.exception.BusinessException;
//import com.example.accountservice.response.ResponseData;
//import com.example.accountservice.response.feign.Response;
//import com.fasterxml.jackson.databind.ObjectMapper;
//import jakarta.validation.groups.Default;
//import lombok.RequiredArgsConstructor;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.http.HttpStatus;
//import org.springframework.stereotype.Component;
//import org.springframework.web.server.ResponseStatusException;
//
//import java.io.BufferedReader;
//import java.io.InputStream;
//import java.io.InputStreamReader;
//import java.nio.charset.StandardCharsets;
//import java.util.Objects;
//import java.util.stream.Collectors;
//
//@Slf4j
//@Component
//@RequiredArgsConstructor
//public class InternalRestErrorDecoder implements ErrorDecoder {
//
//    private final ErrorDecoder defaultErrorDecoder = new Default();
//
//    private final ObjectMapper objectMapper = new ObjectMapper();
//
//    @Override
//    public Exception decode(String methodKey, Response response) {
//
//        Object exception;
//
//        if (Objects.nonNull(Response.body())) {
//
//            try (InputStream inputStream = Response.body().asInputStream()) {
//                String bodyAsString = new BufferedReader(new InputStreamReader(inputStream, StandardCharsets.UTF_8))
//                        .lines()
//                        .collect(Collectors.joining("\n"));
//
//                log.error("[FeignClient response error] - method: {} - error: {}", methodKey, bodyAsString);
//
//                ResponseData responseData = objectMapper.readValue(bodyAsString, ResponseData.class);
//
//                if (Objects.isNull(responseData)) {
//                    return defaultErrorDecoder.decode(methodKey, response);
//                }
//
//                exception = new ResponseStatusException(HttpStatus.OK, responseData.toString());
//
//            } catch (Exception e) {
//                log.error("Exception | decode: ", e);
//                throw new BusinessException(ErrorCode.UNKNOWN_ERROR);
//            }
//        }
//
//        // Xử lý các status đặc biệt
//        if (response.getStatus() == HttpStatus.UNAUTHORIZED.value() ||
//                response.getStatus() == HttpStatus.FORBIDDEN.value()) {
//            exception = new UnauthorizedClientException("Unauthorized");
//        }
//
//        // Nếu không có exception thì fallback RuntimeException
//        return (exception != null)
//                ? exception
//                : new RuntimeException(response.getReason());
//    }
//}
