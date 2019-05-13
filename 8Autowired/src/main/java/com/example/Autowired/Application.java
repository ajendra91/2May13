package com.example.Autowired;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Application implements CommandLineRunner {

	@Autowired
	public HelloController hc;

	public HelloController hc1=new HelloController();

	public static void main(String[] args) {

		SpringApplication app = new SpringApplication(Application.class);
		app.run(args);

		//ApplicationContext ac1=SpringApplication.run(Application.class, args);
		//HelloController hc2=ac1.getBean(HelloController.class);
		//System.out.println(hc2.hello());

		//ConfigurableApplicationContext ac2=SpringApplication.run(Application.class, args);
		//HelloController hc3=ac2.getBean(HelloController.class);
		//System.out.println(hc3.hello());
	}

	@Bean
	public CommandLineRunner fun(){
		return args -> {
			System.out.println(hc.hello());
		};
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println(hc.hello());
	}
}
