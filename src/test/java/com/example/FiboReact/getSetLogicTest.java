package com.example.FiboReact;
import com.example.FiboReact.entities.ValueOfYAML;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.springframework.boot.test.context.SpringBootTest;

public class getSetLogicTest {
    //Бессмысленные тесты getter/setter
    @Test
    public void waitTest(){
        Logic logic = new Logic(new ValueOfYAML());
        logic.setWait(500);

        assertEquals(500, logic.getWait(), "Wait must be 500");
    }

    @Test
    public void sizeTest(){
        Logic logic = new Logic(new ValueOfYAML());
        logic.setSize(100);

        assertEquals(100, logic.getSize(), "Size must be 100");
    }

    @Test
    public void minValueTest(){
        Logic logic = new Logic(new ValueOfYAML());
        logic.setMinValue(10);

        assertEquals(10, logic.getMinValue(), "MinValue must be 10");
    }

    @Test
    public void maxValueTest(){
        Logic logic = new Logic(new ValueOfYAML());
        logic.setMaxValue(100);

        assertEquals(100, logic.getMaxValue(), "MaxValue must be 100");
    }

    @Test
    public void skipsTest(){
        Logic logic = new Logic(new ValueOfYAML());
        logic.setSkips(1);

        assertEquals(1, logic.getSkips(), "Skips must be 1");
    }

    @Test
    public void takesTest(){
        Logic logic = new Logic(new ValueOfYAML());
        logic.setTakes(10);

        assertEquals(10, logic.getTakes(), "Takes must be 10");
    }

    @Test
    public void multTest(){
        Logic logic = new Logic(new ValueOfYAML());
        logic.setMult(2);

        assertEquals(2, logic.getMult(), "Mult must be 2");
    }
}
