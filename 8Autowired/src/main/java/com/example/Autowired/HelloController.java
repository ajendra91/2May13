package com.example.Autowired;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @Autowired
    public HelloService hs;

    @RequestMapping("")
    public String hello(){
        return hs.demo();
    }

}
