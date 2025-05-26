package com.quest.pft.personal_financial_tracker.model;

import com.quest.pft.personal_financial_tracker.model.enums.AccountType;
import lombok.Data;

import java.sql.Timestamp;

@Data
public class User {
    private String id ;
    private String name;
    private String encryptedPassword;
    private AccountType accountType;
    private String email;
    private String phoneNumber;
    private float income;
    private Timestamp createdTs;
    private Timestamp updatedTs;
}
