package com.test.exception;

import com.test.exception.base.BaseRuntimeException;
import com.test.exception.base.ExceptionType;

public class AccessDeniedException extends BaseRuntimeException {
    public AccessDeniedException() {
        super(ExceptionType.ACCESS_DENIED);
    }
}
