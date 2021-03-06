package com.bnc.api.config;

import com.bnc.common.support.Constants;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import static com.bnc.common.support.Constants.COMMON_BASE_PACKAGE;

@EntityScan(basePackages = COMMON_BASE_PACKAGE)
@EnableJpaRepositories(basePackages = COMMON_BASE_PACKAGE)
@ComponentScan(value = COMMON_BASE_PACKAGE)
@Configuration
public class CommonModuleConfiguration {
}
