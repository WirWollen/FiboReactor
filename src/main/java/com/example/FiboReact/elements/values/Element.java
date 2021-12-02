package com.example.FiboReact.elements.values;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor(access = AccessLevel.PUBLIC)
public class Element implements GetValue {
    private final int value;

    public int getValue(){
        return value;
    }
}
