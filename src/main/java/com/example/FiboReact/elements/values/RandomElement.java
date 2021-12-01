package com.example.FiboReact.elements.values;

public class RandomElement implements GetValue {
    public int getValue(){
        return (int)(Math.random() * 100);
    }
}
