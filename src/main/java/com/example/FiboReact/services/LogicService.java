package com.example.FiboReact.services;

import com.example.FiboReact.elements.factory.RandomElementFactory;
import com.example.FiboReact.elements.values.GetValue;
import com.example.FiboReact.entities.ValueOfYAML;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import reactor.core.Disposable;
import reactor.core.publisher.Flux;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;


@RequiredArgsConstructor(access = AccessLevel.PUBLIC)
public class LogicService {
    //Получаем данные из .yml
    private final ValueOfYAML valueOfYAML;

    private RandomElementFactory randomElementFactory = new RandomElementFactory();
    private List<GetValue> elementList = new ArrayList<>();

    public void fillList() {
        elementList = IntStream.range(0, valueOfYAML
                .getSize())
                .mapToObj(i -> randomElementFactory.createElement())
                .collect(Collectors.toList());
    }

    //Обработчик коллекции, который выбирает (min <= Число <= max)
    public Flux<GetValue> fluxGenerator() {
        return  Flux.fromIterable(elementList)
                .filter(valueOf -> valueOf
                        .getValue() >= valueOfYAML.getMinValue() && valueOf.getValue() <= valueOfYAML.getMaxValue());
    }

    public Flux subscriberMaxFirst() {
        return fluxGenerator()
                .map(valueOf-> valueOf.getValue())
                .delayElements(valueOfYAML.getWait());
    }

    public Flux subscriberMaxSecond() {
                return fluxGenerator()
                        .map(valueOf -> valueOfYAML.getMult() * valueOf.getValue())
                        .skip(valueOfYAML.getSkips())
                        .take(valueOfYAML.getTakes());
    }

    //возвращается флас и прокинуть методы в рест-контроллер
    public void showSubscriberMaxFirst(){
        subscriberMaxFirst()
                .doOnTerminate(() -> System.out.println("First completed"))
                .subscribe(System.out::println);
    }

    public void showSubscriberMaxSecond() {
        subscriberMaxSecond()
                .doOnTerminate(() -> System.out.println("Second completed"))
                .subscribe(System.out::println);
    }

}