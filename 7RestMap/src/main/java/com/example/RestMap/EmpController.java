package com.example.RestMap;

import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/emp")
public class EmpController {

    public static Map<Integer, Emp> emap=new HashMap<Integer, Emp>();
    public static Set<Emp> eset=new HashSet<Emp>();

    static {
        emap.put(101,new Emp(101,"java","25"));
        emap.put(102,new Emp(102,"java","25"));
        emap.put(103,new Emp(103,"java","25"));

        eset.add(new Emp(1,"java","25"));
        eset.add(new Emp(2,"java","25"));
        eset.add(new Emp(3,"java","25"));
    }

    @RequestMapping("")
    public Map<Integer,Emp> getAll(){
        return emap;
    }

    @RequestMapping("/emp2")
    public Collection<Emp> getAll2(){
        return emap.values();
    }

    @RequestMapping("/emp3")
    public Set<Emp> getAll3(){
        return eset;
    }

    @RequestMapping(value = "/{id}")
    public Emp getId(@PathVariable int id){
        return emap.get(id);
    }

    @RequestMapping(value = "", method = RequestMethod.POST)
    public void add(@RequestBody Emp emp){
        emap.put(emp.getId(),emp);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public void update(@PathVariable int id,@RequestBody Emp emp){
        if(emp!=null && emap.containsKey(id)){
            emap.put(id,emp);
        }
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable int id){
        if(emap!=null && emap.containsKey(id)){
            emap.remove(id);
        }
    }

}
