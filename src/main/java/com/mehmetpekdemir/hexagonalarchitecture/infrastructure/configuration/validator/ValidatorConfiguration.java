package com.mehmetpekdemir.hexagonalarchitecture.infrastructure.configuration.validator;

import org.springframework.context.annotation.Configuration;
import org.springframework.validation.Validator;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import lombok.RequiredArgsConstructor;

/**
 * @author MEHMET PEKDEMIR
 * @since 1.0
 */
@Configuration
@RequiredArgsConstructor
public class ValidatorConfiguration implements WebMvcConfigurer {

    private final Validator validator;

    @Override
    public Validator getValidator() {
        return validator;
    }

}