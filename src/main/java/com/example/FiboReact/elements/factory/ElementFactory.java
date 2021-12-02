package com.example.FiboReact.elements.factory;

import com.example.FiboReact.elements.values.HasElement;
import com.example.FiboReact.elements.values.Element;

public class ElementFactory implements ElementFactoryCreator {
    @Override
    public HasElement createElement(){
        return new Element((int)(Math.random() * 100));
    }
}
