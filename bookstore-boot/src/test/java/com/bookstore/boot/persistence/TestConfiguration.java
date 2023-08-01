package com.bookstore.boot.persistence;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableJpaRepositories(basePackages = {"com.bookstore.boot.persistence"})
@PropertySource("application-test.properties")
@EnableTransactionManagement
public class TestConfiguration {
}
