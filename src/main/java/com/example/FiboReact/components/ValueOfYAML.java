package com.example.FiboReact.components;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.time.Duration;

@ConfigurationProperties(prefix = "logical-element")
@Data
@Component
public class ValueOfYAML {
    //Получаем данные из .yml

    private Duration wait;
    private int size;
    private int maxValue, minValue;
    private int skips, takes;
    private int mult;
}
