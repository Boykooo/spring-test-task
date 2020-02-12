package com.test.exception;

import com.test.exception.base.BaseRuntimeException;
import com.test.exception.base.ExceptionType;

public class LoginOrPasswordIncorrectException extends BaseRuntimeException {
    public LoginOrPasswordIncorrectException() {
        super(ExceptionType.LOGIN_OR_PASSWORD_INCORRECT);
    }
}
