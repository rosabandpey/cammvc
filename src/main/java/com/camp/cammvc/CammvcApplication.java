package com.camp.cammvc;

import com.camp.cammvc.entity.ResponseToken;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.context.annotation.ApplicationScope;

import java.time.Duration;

@SpringBootApplication
public class CammvcApplication {

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
    @ApplicationScope
    public ResponseToken applicationScopedBean() {
        return new ResponseToken();
    }

}
