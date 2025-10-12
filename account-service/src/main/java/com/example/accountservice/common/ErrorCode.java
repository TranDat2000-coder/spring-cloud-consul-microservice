package com.example.accountservice.common;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public enum ErrorCode {

    TOKEN_EXPIRED("01","Token is expired"),
    UNAUTHORIZED("02", "Your access rights have expired, please re-authenticate"),
    UNKNOWN_ERROR("03", "Unknown error");
    ;

    private String errorCode;

    private String message;

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
