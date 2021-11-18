package com.example.FiboReact;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("com.example.FiboReact")
public class AnotherComponent {
    @Bean("Logic")
    public Logic getLogic(){
        return new Logic();
    }
}
