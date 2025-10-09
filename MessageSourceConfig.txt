package com.proyecto.cabapro.config;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ResourceBundleMessageSource;

@Configuration
public class MessageSourceConfig {

    @Bean
    public MessageSource messageSource() {
        ResourceBundleMessageSource source = new ResourceBundleMessageSource();
        source.setBasename("messages"); // nombre base de tus archivos messages*.properties
        source.setDefaultEncoding("UTF-8"); // para caracteres acentuados
        return source;
    }
}
