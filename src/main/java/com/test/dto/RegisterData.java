package com.test.dto;

import lombok.Getter;

import javax.validation.constraints.NotEmpty;

@Getter
public class RegisterData extends Crendentials {
    @NotEmpty
    private String fullname;
}
