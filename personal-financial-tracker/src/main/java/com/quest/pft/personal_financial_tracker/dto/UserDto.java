package com.quest.pft.personal_financial_tracker.dto;

import com.quest.pft.personal_financial_tracker.model.enums.AccountType;
import lombok.Data;

@Data
public class UserDto {

    private String name;
    private String password;
    private String accountType;
    private String email;
    private String phoneNumber;
    private float income;
}
