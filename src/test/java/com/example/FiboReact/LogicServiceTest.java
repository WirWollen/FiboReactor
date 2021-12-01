//package com.example.FiboReact;
//
//import com.example.FiboReact.entities.ValueOfYAML;
//import com.example.FiboReact.services.LogicService;
//import org.junit.jupiter.api.Test;
//
//import reactor.test.StepVerifier;
//
//import java.time.Duration;
//
//public class LogicServiceTest {
//    //Тесты Flux
//
//    //Создаётся ArrayList в 4 элемента и заполняется Element, проверяется соответствие minValue <= element.getRandomNum() <= maxValue
//    //Проверка рассчитана на 4 элемента
//    @Test
//    public void subscriberMaxFirstTest(){
//        LogicService logicService = new LogicService(new ValueOfYAML());
//
//        logicService.valueOfYAML.setMinValue(0);
//        logicService.valueOfYAML.setSize(4);
//        logicService.valueOfYAML.setMaxValue(100);
//        logicService.valueOfYAML.setWait(0);
//
//        logicService.fillList();
//
//        StepVerifier.create(logicService.subscriberMaxFirst())
//                .expectNextMatches(element -> element >= logicService.valueOfYAML.getMinValue() && element <= logicService.valueOfYAML.getMaxValue())
//                .expectNextMatches(element -> element >= logicService.valueOfYAML.getMinValue() && element <= logicService.valueOfYAML.getMaxValue())
//                .expectNextMatches(element -> element >= logicService.valueOfYAML.getMinValue() && element <= logicService.valueOfYAML.getMaxValue())
//                .expectNextMatches(element -> element >= logicService.valueOfYAML.getMinValue() && element <= logicService.valueOfYAML.getMaxValue())
//                .expectComplete()
//                .verify();
//    }
//
//    //То же самое, что сверху, но автоматизировано
//    @Test
//    public void autoSubscriberMaxFirstTest(){
//        LogicService logicService = new LogicService(new ValueOfYAML());
//
//        logicService.valueOfYAML.setMinValue(0);
//        logicService.valueOfYAML.setTakes(10);
//        logicService.valueOfYAML.setSize(25);
//        logicService.valueOfYAML.setSkips(0);
//        logicService.valueOfYAML.setMaxValue(100);
//        logicService.valueOfYAML.setWait(500);
//        logicService.valueOfYAML.setMult(2);
//
//        logicService.fillList();
//
//        logicService.fluxGenerator().toStream().forEach(System.out::println);
//
//        StepVerifier.create(logicService.subscriberMaxFirst())
//                .thenConsumeWhile(element -> element >= logicService.valueOfYAML.getMinValue() && element <= logicService.valueOfYAML.getMaxValue())
//                .expectComplete()
//                .verify();
//    }
//
//
//    //Проверка задержки
//    @Test
//    public void timeSubscriberMaxFirstTest(){
//        LogicService logicService = new LogicService(new ValueOfYAML());
//
//        logicService.valueOfYAML.setMinValue(0);
//        logicService.valueOfYAML.setTakes(10);
//        logicService.valueOfYAML.setSize(5);
//        logicService.valueOfYAML.setSkips(0);
//        logicService.valueOfYAML.setMaxValue(100);
//        logicService.valueOfYAML.setWait(2000);
//        logicService.valueOfYAML.setMult(2);
//
//        logicService.fillList();
//
//        logicService.fluxGenerator().toStream().forEach(System.out::println);
//
//        StepVerifier
//                .withVirtualTime(() -> logicService.subscriberMaxFirst().take(2))
//                .expectSubscription()
//                .expectNoEvent(Duration.ofMillis(2000))
//                .expectNextMatches(element -> element >= logicService.valueOfYAML.getMinValue() && element <= logicService.valueOfYAML.getMaxValue())
//                .thenAwait(Duration.ofMillis(2000))
//                .expectNextMatches(element -> element >= logicService.valueOfYAML.getMinValue() && element <= logicService.valueOfYAML.getMaxValue())
//                .verifyComplete();
//    }
//
//    //Аналог первых двух тестов, но для subscriberMaxSecond
//    @Test
//    public void subscriberMaxSecondTest(){
//        LogicService logicService = new LogicService(new ValueOfYAML());
//
//        logicService.valueOfYAML.setMinValue(0);
//        logicService.valueOfYAML.setSize(4);
//        logicService.valueOfYAML.setMaxValue(100);
//        logicService.valueOfYAML.setMult(2);
//        logicService.valueOfYAML.setSkips(0);
//        logicService.valueOfYAML.setTakes(4);
//
//        logicService.fillList();
//
//        StepVerifier.create(logicService.subscriberMaxSecond())
//                .expectNextMatches(element -> element / logicService.valueOfYAML.getMult() >= logicService.valueOfYAML.getMinValue() && element / logicService.valueOfYAML.getMult() <= logicService.valueOfYAML.getMaxValue())
//                .expectNextMatches(element -> element / logicService.valueOfYAML.getMult() >= logicService.valueOfYAML.getMinValue() && element / logicService.valueOfYAML.getMult() <= logicService.valueOfYAML.getMaxValue())
//                .expectNextMatches(element -> element / logicService.valueOfYAML.getMult() >= logicService.valueOfYAML.getMinValue() && element / logicService.valueOfYAML.getMult() <= logicService.valueOfYAML.getMaxValue())
//                .expectNextMatches(element -> element / logicService.valueOfYAML.getMult() >= logicService.valueOfYAML.getMinValue() && element / logicService.valueOfYAML.getMult() <= logicService.valueOfYAML.getMaxValue())
//                .expectComplete()
//                .verify();
//    }
//
//    @Test
//    public void autoSubscriberMaxSecondTest(){
//        LogicService logicService = new LogicService(new ValueOfYAML());
//
//        logicService.valueOfYAML.setMinValue(0);
//        logicService.valueOfYAML.setSize(10);
//        logicService.valueOfYAML.setMaxValue(100);
//        logicService.valueOfYAML.setMult(2);
//        logicService.valueOfYAML.setSkips(0);
//        logicService.valueOfYAML.setTakes(10);
//
//        logicService.fillList();
//
//        logicService.fluxGenerator().toStream().forEach(System.out::println);
//
//        StepVerifier.create(logicService.subscriberMaxSecond())
//                .thenConsumeWhile(element -> element / logicService.valueOfYAML.getMult() >= logicService.valueOfYAML.getMinValue() && element / logicService.valueOfYAML.getMult() <= logicService.valueOfYAML.getMaxValue())
//                .expectComplete()
//                .verify();
//    }
//
//
//}