package com.example.FiboReact.elements;

public class ElementGetter {
    private final ElementFactory elementFactory;

    public ElementGetter(ElementFactory elementFactory){
        this.elementFactory = elementFactory;
    }

    public Element orderElement(ElementType type){
        Element element = elementFactory.createElement(type);
        return element;
    }
}
