package com.example.FiboReact;

import com.example.FiboReact.entities.ValueOfYAML;
import org.junit.jupiter.api.Test;

import reactor.test.StepVerifier;

import java.time.Duration;

public class LogicTest {
    //Тесты Flux

    //Создаётся ArrayList в 4 элемента и заполняется Element, проверяется соответствие minValue <= element.getRandomNum() <= maxValue
    //Проверка рассчитана на 4 элемента
    @Test
    public void subscriberMaxFirstTest(){
        Logic logic = new Logic(new ValueOfYAML());

        logic.valueOfYAML.setMinValue(0);
        logic.valueOfYAML.setSize(4);
        logic.valueOfYAML.setMaxValue(100);
        logic.valueOfYAML.setWait(0);

        logic.fillList();

        StepVerifier.create(logic.subscriberMaxFirst())
                .expectNextMatches(element -> element >= logic.valueOfYAML.getMinValue() && element <= logic.valueOfYAML.getMaxValue())
                .expectNextMatches(element -> element >= logic.valueOfYAML.getMinValue() && element <= logic.valueOfYAML.getMaxValue())
                .expectNextMatches(element -> element >= logic.valueOfYAML.getMinValue() && element <= logic.valueOfYAML.getMaxValue())
                .expectNextMatches(element -> element >= logic.valueOfYAML.getMinValue() && element <= logic.valueOfYAML.getMaxValue())
                .expectComplete()
                .verify();
    }

    //То же самое, что сверху, но автоматизировано
    @Test
    public void autoSubscriberMaxFirstTest(){
        Logic logic = new Logic(new ValueOfYAML());

        logic.valueOfYAML.setMinValue(0);
        logic.valueOfYAML.setTakes(10);
        logic.valueOfYAML.setSize(25);
        logic.valueOfYAML.setSkips(0);
        logic.valueOfYAML.setMaxValue(100);
        logic.valueOfYAML.setWait(500);
        logic.valueOfYAML.setMult(2);

        logic.fillList();

        logic.fluxGenerator().toStream().forEach(System.out::println);

        StepVerifier.create(logic.subscriberMaxFirst())
                .thenConsumeWhile(element -> element >= logic.valueOfYAML.getMinValue() && element <= logic.valueOfYAML.getMaxValue())
                .expectComplete()
                .verify();
    }


    //Проверка задержки
    @Test
    public void timeSubscriberMaxFirstTest(){
        Logic logic = new Logic(new ValueOfYAML());

        logic.valueOfYAML.setMinValue(0);
        logic.valueOfYAML.setTakes(10);
        logic.valueOfYAML.setSize(5);
        logic.valueOfYAML.setSkips(0);
        logic.valueOfYAML.setMaxValue(100);
        logic.valueOfYAML.setWait(2000);
        logic.valueOfYAML.setMult(2);

        logic.fillList();

        logic.fluxGenerator().toStream().forEach(System.out::println);

        StepVerifier
                .withVirtualTime(() -> logic.subscriberMaxFirst().take(2))
                .expectSubscription()
                .expectNoEvent(Duration.ofMillis(2000))
                .expectNextMatches(element -> element >= logic.valueOfYAML.getMinValue() && element <= logic.valueOfYAML.getMaxValue())
                .thenAwait(Duration.ofMillis(2000))
                .expectNextMatches(element -> element >= logic.valueOfYAML.getMinValue() && element <= logic.valueOfYAML.getMaxValue())
                .verifyComplete();
    }

    //Аналог первых двух тестов, но для subscriberMaxSecond
    @Test
    public void subscriberMaxSecondTest(){
        Logic logic = new Logic(new ValueOfYAML());

        logic.valueOfYAML.setMinValue(0);
        logic.valueOfYAML.setSize(4);
        logic.valueOfYAML.setMaxValue(100);
        logic.valueOfYAML.setMult(2);
        logic.valueOfYAML.setSkips(0);
        logic.valueOfYAML.setTakes(4);

        logic.fillList();

        StepVerifier.create(logic.subscriberMaxSecond())
                .expectNextMatches(element -> element / logic.valueOfYAML.getMult() >= logic.valueOfYAML.getMinValue() && element / logic.valueOfYAML.getMult() <= logic.valueOfYAML.getMaxValue())
                .expectNextMatches(element -> element / logic.valueOfYAML.getMult() >= logic.valueOfYAML.getMinValue() && element / logic.valueOfYAML.getMult() <= logic.valueOfYAML.getMaxValue())
                .expectNextMatches(element -> element / logic.valueOfYAML.getMult() >= logic.valueOfYAML.getMinValue() && element / logic.valueOfYAML.getMult() <= logic.valueOfYAML.getMaxValue())
                .expectNextMatches(element -> element / logic.valueOfYAML.getMult() >= logic.valueOfYAML.getMinValue() && element / logic.valueOfYAML.getMult() <= logic.valueOfYAML.getMaxValue())
                .expectComplete()
                .verify();
    }

    @Test
    public void autoSubscriberMaxSecondTest(){
        Logic logic = new Logic(new ValueOfYAML());

        logic.valueOfYAML.setMinValue(0);
        logic.valueOfYAML.setSize(10);
        logic.valueOfYAML.setMaxValue(100);
        logic.valueOfYAML.setMult(2);
        logic.valueOfYAML.setSkips(0);
        logic.valueOfYAML.setTakes(10);

        logic.fillList();

        logic.fluxGenerator().toStream().forEach(System.out::println);

        StepVerifier.create(logic.subscriberMaxSecond())
                .thenConsumeWhile(element -> element / logic.valueOfYAML.getMult() >= logic.valueOfYAML.getMinValue() && element / logic.valueOfYAML.getMult() <= logic.valueOfYAML.getMaxValue())
                .expectComplete()
                .verify();
    }


}