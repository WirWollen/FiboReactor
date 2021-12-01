package com.example.FiboReact.elements.factory;

import com.example.FiboReact.elements.values.GetValue;
import com.example.FiboReact.elements.values.RandomElement;

public class RandomElementFactory implements ElementCreator {
    @Override
    public GetValue createElement(){
        return new RandomElement();
    }
}
