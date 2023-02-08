package com.assigment.controller;

import com.assigment.response.GetUserResponse;
import com.assigment.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("user")
@AllArgsConstructor
public class UserController {

    private UserService userService;

    @GetMapping(value = "/{userId}")
    @ResponseStatus(HttpStatus.OK)
    public GetUserResponse getAccount(@PathVariable long userId) {
        return userService.getAccountDetailed(userId);
    }
}

