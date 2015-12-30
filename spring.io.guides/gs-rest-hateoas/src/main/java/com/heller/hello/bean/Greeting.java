package com.heller.hello.bean;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.hateoas.ResourceSupport;

@Getter
@Setter
@ToString
public class Greeting extends ResourceSupport {

    private String content;

}
