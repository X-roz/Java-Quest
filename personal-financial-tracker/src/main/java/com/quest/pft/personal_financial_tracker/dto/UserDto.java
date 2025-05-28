package com.quest.pft.personal_financial_tracker.dto;

import com.quest.pft.personal_financial_tracker.model.enums.AccountType;

public class UserDto {

    private String name;
    private String password;
    private AccountType accountType;
    private String email;
    private String phoneNumber;
    private float income;
}
