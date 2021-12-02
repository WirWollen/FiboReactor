package com.example.FiboReact.elements.factory;

import com.example.FiboReact.elements.values.HasValue;
import com.example.FiboReact.elements.values.Element;
import org.springframework.stereotype.Component;

@Component
public class RandomElementFactoryFactory implements ElementFactory {
    @Override
    public HasValue createElement(){
        return new Element((int)(Math.random() * 100));
    }
}
