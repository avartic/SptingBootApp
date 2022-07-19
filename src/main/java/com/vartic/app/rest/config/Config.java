package com.vartic.app.rest.config;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories("com.vartic.app.rest.repos")
@Configuration
@EntityScan(basePackages = {"com.vartic.app.rest.entity"})
public class Config {
}
