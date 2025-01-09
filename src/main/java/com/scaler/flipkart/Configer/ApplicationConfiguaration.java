package com.scaler.flipkart.Configer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class ApplicationConfiguaration {
    @Bean
    public RestTemplate createResttemplate() {
        return new RestTemplate();
    }
}
