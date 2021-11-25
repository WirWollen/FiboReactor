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

        logic.setMinValue(0);
        logic.setSize(4);
        logic.setMaxValue(100);
        logic.setWait(0);

        logic.fillList();

        StepVerifier.create(logic.subscriberMaxFirst())
                .expectNextMatches(element -> element >= logic.getMinValue() && element <= logic.getMaxValue())
                .expectNextMatches(element -> element >= logic.getMinValue() && element <= logic.getMaxValue())
                .expectNextMatches(element -> element >= logic.getMinValue() && element <= logic.getMaxValue())
                .expectNextMatches(element -> element >= logic.getMinValue() && element <= logic.getMaxValue())
                .expectComplete()
                .verify();
    }

    //То же самое, что сверху, но автоматизировано
    @Test
    public void autoSubscriberMaxFirstTest(){
        Logic logic = new Logic(new ValueOfYAML());

        logic.setMinValue(0);
        logic.setTakes(10);
        logic.setSize(25);
        logic.setSkips(0);
        logic.setMaxValue(100);
        logic.setWait(500);
        logic.setMult(2);

        logic.fillList();

        logic.fluxGenerator().toStream().forEach(System.out::println);

        StepVerifier.create(logic.subscriberMaxFirst())
                .thenConsumeWhile(element -> element >= logic.getMinValue() && element <= logic.getMaxValue())
                .expectComplete()
                .verify();
    }


    //Проверка задержки
    @Test
    public void timeSubscriberMaxFirstTest(){
        Logic logic = new Logic(new ValueOfYAML());

        logic.setMinValue(0);
        logic.setTakes(10);
        logic.setSize(5);
        logic.setSkips(0);
        logic.setMaxValue(100);
        logic.setWait(2000);
        logic.setMult(2);

        logic.fillList();

        logic.fluxGenerator().toStream().forEach(System.out::println);

        StepVerifier
                .withVirtualTime(() -> logic.subscriberMaxFirst().take(2))
                .expectSubscription()
                .expectNoEvent(Duration.ofMillis(2000))
                .expectNextMatches(element -> element >= logic.getMinValue() && element <= logic.getMaxValue())
                .thenAwait(Duration.ofMillis(2000))
                .expectNextMatches(element -> element >= logic.getMinValue() && element <= logic.getMaxValue())
                .verifyComplete();
    }

    //Аналог первых двух тестов, но для subscriberMaxSecond
    @Test
    public void subscriberMaxSecondTest(){
        Logic logic = new Logic(new ValueOfYAML());

        logic.setMinValue(0);
        logic.setSize(4);
        logic.setMaxValue(100);
        logic.setMult(2);
        logic.setSkips(0);
        logic.setTakes(4);

        logic.fillList();

        StepVerifier.create(logic.subscriberMaxSecond())
                .expectNextMatches(element -> element / logic.getMult() >= logic.getMinValue() && element / logic.getMult() <= logic.getMaxValue())
                .expectNextMatches(element -> element / logic.getMult() >= logic.getMinValue() && element / logic.getMult() <= logic.getMaxValue())
                .expectNextMatches(element -> element / logic.getMult() >= logic.getMinValue() && element / logic.getMult() <= logic.getMaxValue())
                .expectNextMatches(element -> element / logic.getMult() >= logic.getMinValue() && element / logic.getMult() <= logic.getMaxValue())
                .expectComplete()
                .verify();
    }

    @Test
    public void autoSubscriberMaxSecondTest(){
        Logic logic = new Logic(new ValueOfYAML());

        logic.setMinValue(0);
        logic.setSize(10);
        logic.setMaxValue(100);
        logic.setMult(2);
        logic.setSkips(0);
        logic.setTakes(10);

        logic.fillList();

        logic.fluxGenerator().toStream().forEach(System.out::println);

        StepVerifier.create(logic.subscriberMaxSecond())
                .thenConsumeWhile(element -> element / logic.getMult() >= logic.getMinValue() && element / logic.getMult() <= logic.getMaxValue())
                .expectComplete()
                .verify();
    }


}