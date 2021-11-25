package com.example.FiboReact;

import com.example.FiboReact.counts.CountRandomNum;
import lombok.Data;

@Data
public class Element {
    //Получение значения randomNum
    private int randomNum = (new CountRandomNum()).getRandomNum();
}
