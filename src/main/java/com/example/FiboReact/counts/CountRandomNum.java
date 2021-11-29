package com.example.FiboReact.counts;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;

@Component
public class CountRandomNum implements GetNum{
    //@Value("${values-for-elements.randomMax}")
    private int randomMax = 100;

    public int getNum(){
        return (int)(Math.random() * randomMax);
    }
}
