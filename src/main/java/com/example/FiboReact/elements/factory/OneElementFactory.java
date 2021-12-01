package com.example.FiboReact.elements.factory;

import com.example.FiboReact.elements.values.GetValue;
import com.example.FiboReact.elements.values.OneElement;

public class OneElementFactory implements ElementCreator {
    @Override
    public GetValue createElement(){
        return new OneElement();
    }
}
