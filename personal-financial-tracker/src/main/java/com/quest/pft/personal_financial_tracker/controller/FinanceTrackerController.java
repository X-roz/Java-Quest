package com.quest.pft.personal_financial_tracker.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("")
public class FinanceTrackerController {


    @PostMapping("income")
    public void setIncome(){

    }

}
