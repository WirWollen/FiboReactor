package com.example.FiboReact.elements.values;

import com.example.FiboReact.counts.CountRandomNum;
import com.example.FiboReact.elements.Element;
import org.springframework.stereotype.Component;

@Component
public class RandomElement extends Element {
    //Получение значения randomNum

    @Override
    public int getValue(){
        return (new CountRandomNum()).getNum();
    }
}
