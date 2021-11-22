package com.example.FiboReact;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;
import reactor.core.publisher.BaseSubscriber;
import reactor.core.publisher.Flux;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;


@Component
public class Logic {
    //Получаем данные из .yml
    @Value("${logicalElement.wait}")
    private int wait;
    @Value("${logicalElement.size}")
    private int size;
    @Value("${logicalElement.maxValue}")
    private int maxValue;
    @Value("${logicalElement.minValue}")
    private int minValue;
    @Value("${logicalElement.skips}")
    private int skips;
    @Value("${logicalElement.takes}")
    private int takes;
    @Value("${logicalElement.mult}")
    private int mult;


    private ArrayList<Element> elementList = new ArrayList<Element>(size);
    private ArrayList<Integer> fluxElementList = new ArrayList<>();

    public void fillList() {IntStream.range(0, size).forEach(i -> elementList.add(new Element()));}

    Flux<Element> elementGetter;

    //Обработчик коллекции, который выбирает (min < Число < max)
    public void fluxGenerator() {
        Flux<Element> elementProducer = Flux.fromIterable(elementList).filter(element -> {
            if (element.getRandomNum() < maxValue && element.getRandomNum() > minValue) return true;
            else return false;
        });
        elementGetter = elementProducer;
    }


    //Flux подписывается на поток fluxGenerator и выводит полученные элементы с промежутком в "wait"
    public void subscriberMaxFirst() {
        Flux
                .create(sink -> {
                    elementGetter.subscribe(new BaseSubscriber<Element>() {
                        @Override
                        protected void hookOnNext(Element value) {sink.next("Element is " + value.getRandomNum());}

                        @Override
                        protected void hookOnComplete() {sink.complete();}
                    });
                })
                .delayElements(Duration.ofMillis(wait))
                .subscribe(System.out::println);
    }

    //Flux подписывается на поток fluxGenerator, умножает на "mult", пропускает "skips" элементов и берёт "takes" элементов
    public void subscriberMaxSecond() {
        Flux
                .create(sink -> {
                    elementGetter.subscribe(new BaseSubscriber<Element>() {
                        @Override
                        protected void hookOnNext(Element value) {
                            sink.next(fluxElementList.add(mult * value.getRandomNum()));
                        }

                        @Override
                        protected void hookOnComplete() {
                            sink.complete();
                        }
                    });
                })
                .skip(skips)
                .take(takes)
                .subscribe();
    }

    public void showList() {fluxElementList.stream().forEach(System.out::println);}
}
