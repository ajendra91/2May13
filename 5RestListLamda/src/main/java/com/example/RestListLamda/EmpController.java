package com.example.RestListLamda;

import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/emp")
public class EmpController {

    public List<Emp> lst= Collections.singletonList(
            new Emp("a","php","25")
    );

    @RequestMapping("")
    public List<Emp> getAll(){
        return lst.stream().map(e->{
            return new Emp(e.id,e.name,e.age);
        }).collect(Collectors.toList());
    }

    @RequestMapping("/{id}")
    public Emp getId(@PathVariable String id){
        return lst.stream().filter(e->e.id.equals(id)).findFirst().get();

    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public Emp update(@PathVariable String id, @RequestBody Emp emp){

        for (int i=0;i<lst.size();i++){
            Emp e=lst.get(i);
            if(e.id.equals(id)){
                lst.set(i,e);
                return e;
            }
        }
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable String id){
        lst.removeIf(e->e.id.equals(id));
    }


}
