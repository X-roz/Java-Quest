package com.quest.pft.personal_financial_tracker.service;

import com.quest.pft.personal_financial_tracker.cache.UserCacheContainer;
import com.quest.pft.personal_financial_tracker.model.User;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class UserValidationService {

    private final UserCacheContainer userCacheContainer;

    public boolean createUserValidation(User newUser) {

        // Duplicate username check
        if (userCacheContainer.getUserData(newUser.getId()) != null){
            return false;
        }

        return false;
    }

}
