package com.quest.pft.personal_financial_tracker.service;

import com.quest.pft.personal_financial_tracker.cache.UserCacheContainer;
import com.quest.pft.personal_financial_tracker.dto.UserDto;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class UserValidationService {

    private final UserCacheContainer userCacheContainer;

    public boolean createUserValidation(UserDto newUser) {

        // Duplicate username check
        if (userCacheContainer.isUserNameExists(newUser.getName())){
            return false; // TODO: need to throws exception with ERROR constants
        }

        return true;
    }

}
