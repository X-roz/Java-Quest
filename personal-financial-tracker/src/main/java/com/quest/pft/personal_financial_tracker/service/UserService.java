package com.quest.pft.personal_financial_tracker.service;

import com.quest.pft.personal_financial_tracker.cache.UserCacheContainer;
import com.quest.pft.personal_financial_tracker.dto.UserDto;
import com.quest.pft.personal_financial_tracker.model.User;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Log4j2
@Service
public class UserService {

    private UserCacheContainer userCacheContainer;

    public void CreateUser(UserDto userDto){
        log.info("Creating new user : {}", userDto);
        User user = new User();
        user.setId(String.valueOf(UUID.randomUUID()));
        user.setIncome(userDto.getIncome());
        user.setEmail(userDto.getEmail());
        user.setName(userDto.getName());
        user.setPhoneNumber(userDto.getPhoneNumber());
        userCacheContainer.addUserData(user);
        log.info("User Created! userId = {}", user.getId());
    }
}
