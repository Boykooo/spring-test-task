package com.test.security;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserInfo {
    protected Long id;
    protected String name;
    protected String login;

    public void build(UserInfo userInfo) {
        this.id = userInfo.getId();
        this.login = userInfo.getLogin();
        this.name = userInfo.getName();
    }

}
