package com.quest.pft.personal_financial_tracker.controller;

import com.quest.pft.personal_financial_tracker.dto.UserDto;
import com.quest.pft.personal_financial_tracker.service.UserService;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.*;

@Log4j2
@RestController
@RequestMapping("user")
public class UserController {

    private UserService userService;

    @PostMapping("create")
    private void createUser(@RequestBody UserDto userDto) {
        userService.CreateUser(userDto);
    }

    @GetMapping("login")
    private void userLogin() {}
}
