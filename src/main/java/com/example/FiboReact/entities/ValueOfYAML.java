package com.example.FiboReact.entities;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@ConfigurationProperties(prefix = "logical-element")
@Data
@Component
public class ValueOfYAML {
    //Получаем данные из .yml
    private int wait;
    private int size;
    private int maxValue;
    private int minValue;
    private int skips;
    private int takes;
    private int mult;
}
