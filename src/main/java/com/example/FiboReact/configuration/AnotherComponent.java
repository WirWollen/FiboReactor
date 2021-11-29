package com.example.FiboReact.configuration;

import com.example.FiboReact.Logic;
import com.example.FiboReact.counts.CountRandomNum;
import com.example.FiboReact.entities.ValueOfYAML;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AnotherComponent {

    @Bean("Logic")
    public Logic getLogic(ValueOfYAML valueOfYAML){
        return new Logic(valueOfYAML);
    }

}
