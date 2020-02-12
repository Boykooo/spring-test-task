package com.test.dto.converter;

import com.test.entity.User;
import com.test.security.UserInfo;

public final class UserConverter {

    public static UserInfo toInfo(User user) {
        return UserInfo.builder()
                .id(user.getId())
                .login(user.getLogin())
                .name(user.getFullname())
                .build();
    }

}
