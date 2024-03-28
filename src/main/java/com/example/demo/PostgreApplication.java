package com.example.demo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.beans.factory.annotation.Autowired;


public class PostgreApplication implements CommandLineRunner{

    @Autowired
    private JdbcTemplate jdbcTemplate;
 

    public void run(String... args) throws Exception{
        String createTable="create table emp(id varchar(30),name varchar(30));";
        String insertRecord="insert into emp(060,akshar);";

        jdbcTemplate.execute(createTable);
        int row=jdbcTemplate.update(insertRecord);
        if(row>0){
            System.out.println("new row inserted successfully");
        }
        
    }
}