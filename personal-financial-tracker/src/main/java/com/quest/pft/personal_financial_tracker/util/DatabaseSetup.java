package com.quest.pft.personal_financial_tracker.util;

import lombok.extern.log4j.Log4j2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

@Log4j2
public class DatabaseSetup {

    private static final String CREATE_USER_TABLE_QUERY = """
            CREATE TABLE USER (
                id VARCHAR(36) PRIMARY KEY,
                name VARCHAR(100),
                encryptedPassword VARCHAR(255),
                email VARCHAR(100) UNIQUE,
                phone VARCHAR(15),
                accountType VARCHAR(20),
                income DECIMAL(12, 2),
                created_ts TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
                updated_ts TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
            );""";


    public static void main(String[] args) {
        try{
            Class.forName("org.sqlite.JDBC");
            Connection connection = DriverManager.getConnection("jdbc:sqlite:C:/Users/HP/vk-works/Java-learnings/Java-Quest/personal-financial-tracker/src/main/resources/sql/pft.sqlite");
            Statement statement = connection.createStatement();

            statement.execute("CREATE DATABASE pft");

            statement.execute("Use pft");

            statement.execute(CREATE_USER_TABLE_QUERY);

            statement.close();
            connection.close();
        } catch (Exception e) {
            log.error("Error in DB connection : {}", e.getMessage());
        }
    }

}
