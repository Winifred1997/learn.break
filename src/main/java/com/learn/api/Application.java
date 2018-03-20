package com.learn.api;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@SpringBootApplication
@EnableAutoConfiguration
@EnableAsync
@EnableCaching
public class Application extends SpringBootServletInitializer {

    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurerAdapter() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**")
                    .allowedOrigins("*")
                    .allowCredentials(true)
                    .allowedMethods("GET", "POST", "DELETE", "PUT", "OPTIONS")
                    .maxAge(3600);
            }
        };
    }

    protected SpringApplicationBuilder configure(
        SpringApplicationBuilder builder) {
        builder.sources(Application.class);
        return builder;
    }

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

}
