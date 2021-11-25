package com.example.FiboReact.counts;

import lombok.Data;
import org.springframework.stereotype.Component;

@Data
@Component
public class CountRandomNum {
    //Стоит ли вытягивать значения "100" из .yml? Или стоит оставить всё как есть?
    //Не уверен, что поправил "Рассчет значений лучше вынести в отдельную сущность. Как вариант заюзать private/package-private конструктор и фабрику."
    public int getRandomNum(){
        return (int)(Math.random() * 100);
    }
}
