package com.example.FiboReact;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.util.ArrayList;
@SpringBootApplication
public class FiboReactApplication {

	public static void main(String[] args) throws InterruptedException {
		ApplicationContext ctx =
				SpringApplication.run(FiboReactApplication.class,args);

		Logic logic = (Logic) ctx.getBean("Logic");

		logic.fillList();
		logic.fluxGenerator();
		logic.subscriberMaxFirst();
		Thread.sleep(4000);
		logic.subscriberMaxSecond();
		logic.showList();
	}

}
