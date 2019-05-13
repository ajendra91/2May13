package com.example.RestTemplate;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@SpringBootApplication
public class RestTemplateApplication {

	public static void main(String[] args) {

		SpringApplication.run(RestTemplateApplication.class, args);

		RestTemplate rt=new RestTemplate();

		String url= "http://localhost:9090/emp";

		//System.out.println(rt.getForObject("https://api.github.com/users/ajendra",String.class));

		//System.out.println(rt.getForObject("https://graphs.facebook.com/ajendra",String.class));


		System.out.println(rt.getForObject(url, List.class));

		Emp emp= rt.getForObject(url+"/1",Emp.class);
		System.out.println(emp.toString());


	}

	@Bean
	public RestTemplate fun(){
		return new RestTemplate();
	}

}
