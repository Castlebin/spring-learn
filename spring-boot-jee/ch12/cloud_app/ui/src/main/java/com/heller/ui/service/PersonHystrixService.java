package com.heller.ui.service;

import com.heller.ui.domain.Person;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

// PersonService的断路器
@Service
public class PersonHystrixService {

    @Autowired
    private PersonService personService;

    @HystrixCommand(fallbackMethod = "fallbackSave")
    public List<Person> save(String name) {
        return personService.save(name);
    }

    public List<Person> fallbackSave(String name) {
        List<Person> list = new ArrayList<>();
        Person p = new Person(name + "没有保存成功，Person Service 故障");
        list.add(p);

        return list;
    }

}
