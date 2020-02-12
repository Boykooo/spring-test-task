package com.test.exception;

import com.test.exception.base.BaseRuntimeException;
import com.test.exception.base.ExceptionType;

public class UserAlreadyExistsException extends BaseRuntimeException {
    public UserAlreadyExistsException() {
        super(ExceptionType.USER_ALREADY_EXISTS);
    }
}
