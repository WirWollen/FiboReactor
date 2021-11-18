package com.example.FiboReact;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.springframework.boot.test.context.SpringBootTest;
import reactor.core.publisher.Flux;

import java.util.ArrayList;
import java.util.stream.IntStream;

public class LogicTest {
    @Test
    public void testFillCollection(){
        ArrayList<Element> elementList = new ArrayList<Element>();

        IntStream.range(0, 10).forEach(i -> elementList.add(new Element()));

        assertEquals(false, elementList.isEmpty(), "Collection must not be empty");
    }

    @Test
    public void testFluxGenerator(){
        Logic logic = new Logic();
        logic.setSize(100);
        logic.fillList();
        logic.setMinValue(0);
        logic.setMaxValue(10);
        logic.fluxGenerator();
        logic.setSkips(0);
        logic.setTakes(10);
        logic.subscriberMaxSecond();

        ArrayList<Integer> fluxEL = logic.getFluxElementList();

        assertEquals(false, fluxEL.isEmpty(), "Collection must not be empty");
    }

}