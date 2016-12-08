package com.heller.ui.domain;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Person {
    private Long id;
    private String name;

    public Person() {}

    public Person(String name) {
        super();
        this.name = name;
    }

}
