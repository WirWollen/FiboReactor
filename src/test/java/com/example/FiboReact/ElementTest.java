package com.example.FiboReact;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.springframework.boot.test.context.SpringBootTest;

public class ElementTest {

    @Test
    public void testRandom() {
        Element element = new Element();

        assertEquals(true, element.getRandomNum() >= 0, "Random number of element must be >= 0");
    }

    @Test
    public void testGetSet(){
        Element element = new Element();

        element.setRandomNum(5);

        assertEquals(5, element.getRandomNum(), "Number must be 5");
    }


}


