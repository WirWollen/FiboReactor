package com.example.FiboReact;

import com.example.FiboReact.services.LogicService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class FiboReactApplication {

	public static void main(String[] args) throws InterruptedException {
		ApplicationContext ctx = SpringApplication.run(FiboReactApplication.class,args);

		LogicService logicService = (LogicService) ctx.getBean("Logic");

		logicService.fillList();

		logicService.showSubscriberMaxFirst();
		logicService.showSubscriberMaxSecond();
	}
}
