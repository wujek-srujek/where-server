package com.where.server;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.scheduling.annotation.EnableAsync;


@EnableJpaRepositories(enableDefaultTransactions = false)
@EnableAsync
@SpringBootApplication
public class WhereApplication {

    public static void main(String[] args) {
        SpringApplication.run(WhereApplication.class, args);
    }
}
