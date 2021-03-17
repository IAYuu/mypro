package com.jelly.tic;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class DBInitializer {

    final Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    JdbcTemplate jdbcTemplate;

    @PostConstruct
    public void initStation() {
        jdbcTemplate.update("CREATE TABLE IF NOT EXISTS stations(" //
                + "id BIGINT AUTO_INCREMENT  NOT NULL PRIMARY KEY," //
                + "start VARCHAR(50) NOT NULL," //
                + "reach VARCHAR(50) NOT NULL," //
                + "price DOUBLE NOT NULL," //
                + "start_time TIME NOT NULL," //
                + "reach_time TIME NOT NULL)");
    }

    @PostConstruct
    public void initUser() {
        jdbcTemplate.update("CREATE TABLE IF NOT EXISTS users(" //
                + "id BIGINT AUTO_INCREMENT NOT NULL PRIMARY KEY," //
                + "name VARCHAR(50) NOT NULL," //
                + "sex VARCHAR(50) NOT NULL)");
    }

//    @PostConstruct
//    public void initOAuth() {
//        jdbcTemplate.update("CREATE TABLE IF NOT EXISTS local_auth(" //
//                + "oauto_id BIGINT AUTO_INCREMENT NOT NULL PRIMARY KEY," //
//                + "oauto_name varchar(20) NOT NULL,)" //
//                + "oauto_access_token varchar(50) NOT NULL," //
//                + "oauto_expires varchar(20) NOT NULL)");
//   }

    // TODO: 2021/3/15 API访问 API_Auth
}
