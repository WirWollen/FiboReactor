package com.example.FiboReact;

import org.junit.jupiter.api.Test;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;
import reactor.test.publisher.TestPublisher;

import java.util.stream.IntStream;

public class TrialTesting {
    //Не относящиеся к проекту тесты, просто проба возможностей

    @Test
    public void trialTest_1() {
        Flux<Integer> source = Flux.just(1, 2, 3, 4, 5, 6, 7, 8, 9)
                .filter(element -> (element < 90));

        source.toStream().forEach(System.out::println);

        StepVerifier.create(source)
                .thenConsumeWhile(element -> element > 0 && element < 10)
                .expectComplete()
                .verify();
    }

    @Test
    public void trialTest_2(){
        Flux<Element> source = Flux.just(new Element(), new Element(), new Element(), new Element(), new Element())
                .filter(element -> element.getRandomNum() < 0 || element.getRandomNum() > 100);

        source.toStream().forEach(System.out::println);

        StepVerifier.create(source)
                .expectNext()
                .expectComplete()
                .verify();
    }
}
