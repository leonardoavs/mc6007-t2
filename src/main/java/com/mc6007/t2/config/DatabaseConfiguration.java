package com.mc6007.t2.config;

import com.mc6007.t2.data.ravendb.reposiroty.config.EnableRavenDatabaseRepositories;
import io.github.jhipster.config.JHipsterConstants;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;

@Configuration
@EnableRavenDatabaseRepositories(value = "com.mc6007.t2.repository")
@Profile("!" + JHipsterConstants.SPRING_PROFILE_CLOUD)
public class DatabaseConfiguration {

    private final Logger log = LoggerFactory.getLogger(DatabaseConfiguration.class);

    @Bean
    public LocalValidatorFactoryBean validator() {
        return new LocalValidatorFactoryBean();
    }
}
