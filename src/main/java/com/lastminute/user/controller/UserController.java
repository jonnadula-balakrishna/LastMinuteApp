package com.lastminute.user.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    @RequestMapping("/app/v1/sayHi")
    public String sayHi() {
        return "Hello boss";
    }

}
