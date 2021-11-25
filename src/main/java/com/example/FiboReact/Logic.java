package com.example.FiboReact;

import com.example.FiboReact.entities.ValueOfYAML;
import lombok.Data;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Data
@Component
public class Logic {
    //Получаем данные из .yml
    private int wait;
    private int size;
    private int minValue, maxValue;
    private int skips;
    private int takes;
    private int mult;

    private List<Element> elementListWithRandomData = new ArrayList<>(size);

    public Logic(ValueOfYAML valueOfYAML){
        size = valueOfYAML.getSize();
        maxValue = valueOfYAML.getMaxValue();
        minValue = valueOfYAML.getMinValue();
        skips = valueOfYAML.getSkips();
        takes = valueOfYAML.getTakes();
        wait = valueOfYAML.getWait();
        mult = valueOfYAML.getMult();
    }

    public void fillList() {elementListWithRandomData = IntStream.range(0, size).mapToObj(i -> new Element()).collect(Collectors.toList());}

    //Обработчик коллекции, который выбирает (min <= Число <= max)
    public Flux<Element> fluxGenerator() {
        return  Flux.fromIterable(elementListWithRandomData)
                .filter(element -> element
                        .getRandomNum() >= minValue && element.getRandomNum() <= maxValue);
    }

    //Flux подписывается на поток fluxGenerator и выводит полученные элементы с промежутком в "wait"
    public Flux<Integer> subscriberMaxFirst() {
        return fluxGenerator()
                .map(element->element.getRandomNum())
                .delayElements(Duration.ofMillis(wait));
    }

    //Flux подписывается на поток fluxGenerator, умножает на "mult", пропускает "skips" элементов и берёт "takes" элементов
    public Flux<Integer> subscriberMaxSecond() {
                return fluxGenerator()
                        .map(element->mult * element.getRandomNum())
                        .skip(skips)
                        .take(takes);
    }

    public void showSubscriberMaxFirst(){subscriberMaxFirst().toStream().forEach(System.out::println);}

    public void showSubscriberMaxSecond() {subscriberMaxSecond().toStream().forEach(System.out::println);}

    //Не совсем понял смысла .subscribe, ибо получилось всё переписать без него
}