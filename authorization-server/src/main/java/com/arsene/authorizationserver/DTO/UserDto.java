package com.arsene.authorizationserver.DTO;

import lombok.Data;

@Data
public class UserDto {
    private String userName;

    private String password;

    private String email;

    private String mobile;
}
