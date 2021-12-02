package com.example.FiboReact.elements.factory;

import com.example.FiboReact.elements.values.GetValue;
import com.example.FiboReact.elements.values.Element;
import org.springframework.stereotype.Service;

@Service
public class ElementFactory implements ElementCreator {
    @Override
    public GetValue createElement(){
        return new Element((int)(Math.random() * 100));
    }
}
