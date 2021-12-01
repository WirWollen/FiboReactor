//package com.example.FiboReact;
//import com.example.FiboReact.entities.ValueOfYAML;
//import com.example.FiboReact.services.LogicService;
//import org.junit.jupiter.api.Test;
//import static org.junit.jupiter.api.Assertions.assertEquals;
//
//public class getSetLogicServiceTest {
//    //Бессмысленные тесты getter/setter
//    @Test
//    public void waitTest(){
//        LogicService logicService = new LogicService(new ValueOfYAML());
//        logicService.valueOfYAML.setWait(500);
//
//        assertEquals(500, logicService.valueOfYAML.getWait(), "Wait must be 500");
//    }
//
//    @Test
//    public void sizeTest(){
//        LogicService logicService = new LogicService(new ValueOfYAML());
//        logicService.valueOfYAML.setSize(100);
//
//        assertEquals(100, logicService.valueOfYAML.getSize(), "Size must be 100");
//    }
//
//    @Test
//    public void minValueTest(){
//        LogicService logicService = new LogicService(new ValueOfYAML());
//        logicService.valueOfYAML.setMinValue(10);
//
//        assertEquals(10, logicService.valueOfYAML.getMinValue(), "MinValue must be 10");
//    }
//
//    @Test
//    public void maxValueTest(){
//        LogicService logicService = new LogicService(new ValueOfYAML());
//        logicService.valueOfYAML.setMaxValue(100);
//
//        assertEquals(100, logicService.valueOfYAML.getMaxValue(), "MaxValue must be 100");
//    }
//
//    @Test
//    public void skipsTest(){
//        LogicService logicService = new LogicService(new ValueOfYAML());
//        logicService.valueOfYAML.setSkips(1);
//
//        assertEquals(1, logicService.valueOfYAML.getSkips(), "Skips must be 1");
//    }
//
//    @Test
//    public void takesTest(){
//        LogicService logicService = new LogicService(new ValueOfYAML());
//        logicService.valueOfYAML.setTakes(10);
//
//        assertEquals(10, logicService.valueOfYAML.getTakes(), "Takes must be 10");
//    }
//
//    @Test
//    public void multTest(){
//        LogicService logicService = new LogicService(new ValueOfYAML());
//        logicService.valueOfYAML.setMult(2);
//
//        assertEquals(2, logicService.valueOfYAML.getMult(), "Mult must be 2");
//    }
//}
