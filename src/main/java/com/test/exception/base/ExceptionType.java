package com.test.exception.base;

import lombok.Getter;

@Getter
public enum ExceptionType {
    INTERNAL_SERVER_ERROR(1, "Internal Server Error."),
    LOGIN_OR_PASSWORD_INCORRECT(2, "Login or password incorrect."),
    USER_ALREADY_EXISTS(3, "User already exists."),
    ACCESS_DENIED(5, "Access Denied.")
    ;

    private int code;
    private String message;

    ExceptionType(int code, String message) {
        this.code = code;
        this.message = message;
    }

}
