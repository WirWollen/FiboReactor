package com.example.FiboReact;

import com.example.FiboReact.elements.Element;
import com.example.FiboReact.elements.ElementGetter;
import com.example.FiboReact.elements.ElementType;
import com.example.FiboReact.elements.ElementFactory;
import com.example.FiboReact.entities.ValueOfYAML;
import lombok.Data;
import org.springframework.stereotype.Component;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Data
public class Logic {
    //Получаем данные из .yml
    ValueOfYAML valueOfYAML = new ValueOfYAML();


    public Logic(ValueOfYAML valueOfYAML){
        this.valueOfYAML = valueOfYAML;
    }

    private ElementGetter elementGetter = new ElementGetter(new ElementFactory());
    private List<Element> elementList = new ArrayList<>(valueOfYAML.getSize());

    public void fillList() {
        elementList = IntStream.range(0, valueOfYAML
                .getSize())
                .mapToObj(i -> elementGetter.orderElement(ElementType.RandomElement))
                .collect(Collectors.toList());
    }

    //Обработчик коллекции, который выбирает (min <= Число <= max)
    public Flux<Element> fluxGenerator() {
        return  Flux.fromIterable(elementList)
                .filter(valueOf -> valueOf
                        .getValue() >= valueOfYAML.getMinValue() && valueOf.getValue() <= valueOfYAML.getMaxValue()
                );
    }

    //Flux подписывается на поток fluxGenerator и выводит полученные элементы с промежутком в "wait"
    public Flux<Integer> subscriberMaxFirst() {
        return fluxGenerator()
                .map(valueOf-> valueOf.getValue())
                .delayElements(Duration.ofMillis(valueOfYAML.getWait()));
    }

    //Flux подписывается на поток fluxGenerator, умножает на "mult", пропускает "skips" элементов и берёт "takes" элементов
    public Flux<Integer> subscriberMaxSecond() {
                return fluxGenerator()
                        .map(valueOf ->valueOfYAML.getMult() * valueOf.getValue())
                        .skip(valueOfYAML.getSkips())
                        .take(valueOfYAML.getTakes());
    }

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