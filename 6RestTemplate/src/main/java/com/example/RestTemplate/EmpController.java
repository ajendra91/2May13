package com.example.RestTemplate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;

@RestController
@RequestMapping("/rt")
public class EmpController {

    @Autowired
    public RestTemplate rt;

    String url= "http://localhost:9090/emp/";

    @RequestMapping("")
    public String getAll(){
        HttpHeaders headers =new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        HttpEntity entity =new HttpEntity(headers);
        return rt.exchange(url, HttpMethod.GET,entity,String.class).getBody();
    }

    @RequestMapping("/{id}")
    public String getId(@PathVariable int id){
        HttpHeaders headers =new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        HttpEntity entity =new HttpEntity(headers);
        return rt.exchange(url+id, HttpMethod.GET,entity,String.class).getBody();
    }

    @RequestMapping(value = "", method = RequestMethod.POST)
    public String add(@RequestBody Emp emp){
        HttpHeaders headers =new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        HttpEntity<Emp> entity =new HttpEntity<Emp>(emp,headers);
        return rt.exchange(url, HttpMethod.GET,entity,String.class).getBody();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public String update(@PathVariable int id,@RequestBody Emp emp){
        HttpHeaders headers =new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        HttpEntity<Emp> entity =new HttpEntity<Emp>(emp,headers);
        return rt.exchange(url, HttpMethod.GET,entity,String.class).getBody();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public String delete(@PathVariable int id){
        HttpHeaders headers =new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        HttpEntity entity =new HttpEntity(headers);
        return rt.exchange(url+id, HttpMethod.GET,entity,String.class).getBody();
    }


}
