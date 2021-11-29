package com.example.FiboReact.entities;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@ConfigurationProperties(prefix = "logical-element")
@Data
@Component
public class ValueOfYAML {
    //Получаем данные из .yml
//    @Value("${logical-element.wait}")
//    private int wait;
//    @Value("${logical-element.size}")
//    private int size;
//    @Value("${logical-element.maxValue}")
//    private int maxValue;
//    @Value("${logical-element.minValue}")
//    private int minValue;
//    @Value("${logical-element.skips}")
//    private int skips;
//    @Value("${logical-element.takes}")
//    private int takes;
//    @Value("${logical-element.mult}")
//    private int mult;

    private int wait;
    private int size;
    private int maxValue;
    private int minValue;
    private int skips;
    private int takes;
    private int mult;
}
