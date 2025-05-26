package com.quest.pft.personal_financial_tracker.model;

import com.quest.pft.personal_financial_tracker.model.enums.Category;
import com.quest.pft.personal_financial_tracker.model.enums.TransactionType;
import lombok.Data;

import java.sql.Timestamp;

@Data
public class Transaction {
    private String userId;
    private String transactionId;
    private TransactionType transactionType;
    private Category categoryType;
    private String description;
    private float amount;
    private Timestamp createdTs;
}
