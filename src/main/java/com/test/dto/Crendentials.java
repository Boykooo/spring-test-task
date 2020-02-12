package com.test.dto;

import lombok.Getter;

import javax.validation.constraints.NotEmpty;

@Getter
public class Crendentials {
    @NotEmpty
    private String login;
    @NotEmpty
    private String password;
}
