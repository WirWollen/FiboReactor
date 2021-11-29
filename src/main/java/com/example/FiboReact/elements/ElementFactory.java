package com.example.FiboReact.elements;

import com.example.FiboReact.elements.Element;
import com.example.FiboReact.elements.ElementType;
import com.example.FiboReact.elements.values.OneElement;
import com.example.FiboReact.elements.values.RandomElement;

public class ElementFactory {
    public Element createElement(ElementType type){
        Element element = null;

        switch (type){
            case RandomElement:
                element = new RandomElement();
                break;
            case OneElement:
                element = new OneElement();
                break;
        }

        return element;
    }
}
