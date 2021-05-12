package com.camp.cammvc;

import com.camp.cammvc.entity.ResponseToken;
import com.camp.cammvc.modules.config.StringToPlaceConverter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.format.FormatterRegistry;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.context.annotation.ApplicationScope;
import org.springframework.web.context.annotation.SessionScope;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

import java.time.Duration;

@SpringBootApplication
public class CammvcApplication extends WebMvcConfigurationSupport {

    public static void main(String[] args) {
        SpringApplication.run(CammvcApplication.class, args);
    }


    @Bean
    public RestTemplate restTemplate(RestTemplateBuilder builder)
    {
        return builder
                .setConnectTimeout(Duration.ofMillis(3000))
                .setReadTimeout(Duration.ofMillis(3000))
                .build();
    }

    @Bean
    @SessionScope
    public ResponseToken applicationScopedBean() {
        return new ResponseToken();
    }


    @Override
    public void addFormatters(FormatterRegistry registry) {
        registry.addConverter(stringToCategoryConverter());
        super.addFormatters(registry);
    }


    @Bean
    public StringToPlaceConverter stringToCategoryConverter(){
        return new StringToPlaceConverter();
    }
}
