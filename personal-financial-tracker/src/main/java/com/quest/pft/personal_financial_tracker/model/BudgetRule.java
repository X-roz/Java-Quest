package com.quest.pft.personal_financial_tracker.model;

import lombok.Data;

import java.sql.Timestamp;

@Data
public class BudgetRule {

    private String userId;
    private String ruleId;
    private String rule;
    private String ruleOutcome;
    private Timestamp created_ts;
    private Timestamp updated_ts;
}
