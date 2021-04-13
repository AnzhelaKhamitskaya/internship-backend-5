package com.exadel.backendservice.exception;

public class ApiResponseException extends RuntimeException {
    public ApiResponseException(String message) {
        super(message);
    }

    public ApiResponseException(String message, Throwable cause) {
        super(message, cause);
    }
}
