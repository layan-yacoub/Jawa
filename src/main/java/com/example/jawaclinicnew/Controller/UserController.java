package com.example.jawaclinicnew.Controller;

import com.example.jawaclinicnew.Service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping(path = "api/user")
public class UserController {
    private final UserService userService;
}