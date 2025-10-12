package com.example.accountservice.exception;

import com.example.accountservice.common.ErrorCode;
import lombok.Getter;

@Getter
public class BusinessException extends RuntimeException {

    private final ErrorCode errorCode;

    private String detailMessage;

    public BusinessException(ErrorCode errorCode) {
        this.errorCode = errorCode;
    }

    public BusinessException(ErrorCode errorCode, String detailMessage) {
        this.errorCode = errorCode;
        this.detailMessage = detailMessage;
    }

    public String getErrorCode(){
        return this.errorCode.getErrorCode();
    }

    public String getMessage(){
        return this.errorCode.getMessage();
    }
}
