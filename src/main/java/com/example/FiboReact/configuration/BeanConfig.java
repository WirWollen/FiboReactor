package com.example.FiboReact.configuration;

import com.example.FiboReact.elements.factory.RandomElementFactory;
import com.example.FiboReact.elements.factory.ElementFactory;
import com.example.FiboReact.services.LogicService;
import com.example.FiboReact.components.ValueOfYAML;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfig {

    @Bean("Logic")
    public LogicService logic(ValueOfYAML valueOfYAML, ElementFactory elementFactory){
        return new LogicService(valueOfYAML, elementFactory);
    }

    @Bean
    public ElementFactory elementCreator(){
        return new RandomElementFactory();
    }
}
