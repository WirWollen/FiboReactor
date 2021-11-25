package com.example.FiboReact;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.springframework.boot.test.context.SpringBootTest;

public class ElementTest {
    //Тест элемента с рандомным числом
    @Test
    public void testGetSet(){
        Element element = new Element();
        element.setRandomNum(5);
        assertEquals(5, element.getRandomNum(), "Number must be 5");
    }
}


