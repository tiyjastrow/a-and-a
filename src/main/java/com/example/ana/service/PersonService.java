package com.example.ana.service;

import com.example.ana.domain.Person;

import java.util.List;

public interface PersonService {
    Person add(Person person);
    List<Person> getAll();
}
