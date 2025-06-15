package com.quest.pft.personal_financial_tracker.cache;

import com.quest.pft.personal_financial_tracker.model.User;

import java.util.HashMap;
import java.util.Map;

public class UserCacheContainer {

    private final Map<String, User> userContainer = new HashMap<>();

    public void addUserData(User user) {
        userContainer.putIfAbsent(user.getId(), user);
    }

    public User getUserData(String userId) {
        return userContainer.getOrDefault(userId, null);
    }
}
