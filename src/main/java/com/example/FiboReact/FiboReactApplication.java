package com.example.FiboReact;

import com.example.FiboReact.counts.CountRandomNum;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
@ConfigurationPropertiesScan("com.example.FiboReact.entities")
public class FiboReactApplication {

	public static void main(String[] args) throws InterruptedException {
		ApplicationContext ctx = SpringApplication.run(FiboReactApplication.class,args);



		Logic logic = (Logic) ctx.getBean("Logic");

		logic.fillList();

		logic.showSubscriberMaxFirst();
		logic.showSubscriberMaxSecond();
	}

}
