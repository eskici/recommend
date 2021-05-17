package com.moss.project.eneasy.dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Getter
@Setter
public class UserDto extends BaseDto {

    @NotNull
    @NotEmpty(message = "Username can not be empty")
    private String username;

    @NotEmpty(message = "Email can not be empty")
    @Email(message = "Please provide a valid email id")
    private String email;

    @NotNull
    @NotEmpty(message = "Password can not be empty")
    private String password;

    @NotNull
    private String matchingPassword;
}
