package com.example.FiboReact;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
@ConfigurationPropertiesScan("com.example.FiboReact.entities")
public class FiboReactApplication {

	public static void main(String[] args) throws InterruptedException {
		//Мог что-то упустить
		ApplicationContext ctx = SpringApplication.run(FiboReactApplication.class,args);

		Logic logic = (Logic) ctx.getBean("Logic");

		logic.fillList();

		//Не совсем понял про использование метода .block()

		logic.subscriberMaxFirst();
		logic.showSubscriberMaxFirst();
		System.out.println("-----------------");

		//Если я не использовал .subscribe(), то проблема решена?

		//Вот это не всегда может отрабатывать, т.к. перед этим вызывается subscriberMaxFirst(), затем Sleep().
		//subscriberMaxFirst подписывается на elementGetter, а elementGetter не запоминает,
		//какие он там элементы отправлял, ибо не кешированный.

		logic.subscriberMaxSecond();
		logic.showSubscriberMaxSecond();
	}

}
