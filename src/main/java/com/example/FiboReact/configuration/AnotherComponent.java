package com.example.FiboReact.configuration;

import com.example.FiboReact.services.LogicService;
import com.example.FiboReact.entities.ValueOfYAML;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AnotherComponent {

    @Bean("Logic")
    public LogicService getLogic(ValueOfYAML valueOfYAML){
        return new LogicService(valueOfYAML);
    }

}
