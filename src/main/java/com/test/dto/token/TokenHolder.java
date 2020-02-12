package com.test.dto.token;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class TokenHolder {
    private String accessToken;
    private String expiredTime;
}
