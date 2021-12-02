package com.example.FiboReact.services;

import com.example.FiboReact.elements.factory.ElementFactory_CreateElement;
import com.example.FiboReact.elements.values.HasValue;
import com.example.FiboReact.components.ValueOfYAML;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Flux;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;


@RequiredArgsConstructor(access = AccessLevel.PUBLIC)
public class LogicService {
    //Получаем данные из .yml
    private final ValueOfYAML valueOfYAML;
    private final ElementFactory_CreateElement elementFactoryCreateElement;

    private List<HasValue> elementList = new ArrayList<>();

    public void fillList() {
        elementList = IntStream.range(0, valueOfYAML
                .getSize())
                .mapToObj(i -> elementFactoryCreateElement.createElement())
                .collect(Collectors.toList());
    }

    //Обработчик коллекции, который выбирает (min <= Число <= max)
    public Flux<HasValue> fluxGenerator() {
        return  Flux.fromIterable(elementList)
                .filter(valueOf -> valueOf
                        .getValue() >= valueOfYAML.getMinValue() && valueOf.getValue() <= valueOfYAML.getMaxValue());
    }

    public Flux configuratorFirst() {
        return fluxGenerator()
                .map(valueOf-> valueOf.getValue())
                .delayElements(valueOfYAML.getWait());
    }

    public Flux configuratorSecond() {
                return fluxGenerator()
                        .map(valueOf -> valueOfYAML.getMult() * valueOf.getValue())
                        .skip(valueOfYAML.getSkips())
                        .take(valueOfYAML.getTakes());
    }

    public void showConfigurationFirstResult(){
        configuratorFirst()
                .doOnTerminate(() -> System.out.println("First completed"))
                .subscribe(System.out::println);
    }

    public void  showConfigurationSecondResult(){
        configuratorSecond()
                .doOnTerminate(() -> System.out.println("Second completed"))
                .subscribe(System.out::println);
    }

}