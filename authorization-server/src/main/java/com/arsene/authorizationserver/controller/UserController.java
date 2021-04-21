package com.arsene.authorizationserver.controller;

import com.arsene.authorizationserver.DTO.UserDto;
import com.arsene.authorizationserver.model.AuthUser;
import com.arsene.authorizationserver.service.AuthUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/oauth/user")
public class UserController {

    @Autowired
    private AuthUserService authUserService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public AuthUser register(@RequestBody UserDto userDto) {
        try {
            return authUserService.register(userDto);
        }catch (Exception e){

            throw new RuntimeException(e);
        }

    }
}
