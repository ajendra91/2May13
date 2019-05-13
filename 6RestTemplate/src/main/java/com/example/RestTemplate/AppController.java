/*package com.example.RestTemplate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class AppController {


    @Autowired
    public RestTemplate rt;//=new RestTemplate();

    @Autowired
    AppController(RestTemplate rt){
        this.rt=rt;
    }

    @Bean
    public RestTemplate fun(){
        return new RestTemplate();
    }

    @Bean
    public RestTemplate demo(RestTemplateBuilder rtb){
        return rtb.build();
    }

}*/
