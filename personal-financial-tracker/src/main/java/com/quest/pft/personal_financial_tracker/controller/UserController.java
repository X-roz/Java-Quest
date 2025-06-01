package com.quest.pft.personal_financial_tracker.controller;

import com.quest.pft.personal_financial_tracker.config.PasswordConfig;
import com.quest.pft.personal_financial_tracker.dto.UserDto;
import com.quest.pft.personal_financial_tracker.model.User;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@Log4j2
@RestController
@RequestMapping("user")
public class UserController {

    @PostMapping("create")
    private void createUser(@RequestBody UserDto userDto) {
        log.info("Creating new user : {}", userDto);
        User user = new User();
        user.setId(String.valueOf(UUID.randomUUID()));
        user.setIncome(userDto.getIncome());
        user.setEmail(userDto.getEmail());
        user.setName(userDto.getName());
        user.setPhoneNumber(userDto.getPhoneNumber());
//        user.setEncryptedPassword();
//        user.setAccountType();
    }

    @GetMapping("login")
    private void userLogin() {

    }
}
