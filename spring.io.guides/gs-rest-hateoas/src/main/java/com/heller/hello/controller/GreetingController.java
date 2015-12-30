package com.heller.hello.controller;

import com.heller.hello.bean.Greeting;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

@RestController
@RequestMapping("/greeting")
public class GreetingController {

    private static final String TEMPLATE = "Hello, %s!";

    @RequestMapping(method = RequestMethod.GET)
    public HttpEntity<Greeting> greeting(@RequestParam(defaultValue = "World") String name) {
        Greeting greeting = new Greeting();
        greeting.setContent(String.format(TEMPLATE, name));

        greeting.add(linkTo(methodOn(GreetingController.class).greeting(name)).withSelfRel());

        return new ResponseEntity<Greeting>(greeting, HttpStatus.OK);
    }

}
