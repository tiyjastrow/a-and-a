package com.example.ana.service;

import com.example.ana.domain.Person;
import com.example.ana.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class PesonServiceImpl implements PersonService {

    @Autowired
    private PersonRepository personRepository;

    @Transactional
    @Override
    public Person add(Person person) {
        // uncomment to check first name
//        if (person.getFirstName() == null || person.getFirstName().trim().length() == 0) {
//            throw new IllegalArgumentException("first name must be set");
//        }
        return personRepository.save(person);
    }

    @Override
    public List<Person> getAll() {
        return personRepository.findAll();
    }
}
