package com.example.FiboReact.elements.values;

import com.example.FiboReact.counts.CountOne;
import com.example.FiboReact.counts.CountRandomNum;
import com.example.FiboReact.elements.Element;

public class OneElement extends Element {
    @Override
    public int getValue(){
        return (new CountOne()).getNum();
    }
}
