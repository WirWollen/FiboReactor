package com.example.FiboReact.configuration;

import com.example.FiboReact.elements.factory.ElementFactory_CreateElement;
import com.example.FiboReact.services.LogicService;
import com.example.FiboReact.components.ValueOfYAML;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfig {

    @Bean("Logic")
    public LogicService logic(ValueOfYAML valueOfYAML, ElementFactory_CreateElement elementFactory){
        return new LogicService(valueOfYAML, elementFactory);
    }

}
