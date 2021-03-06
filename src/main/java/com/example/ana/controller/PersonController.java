package com.example.ana.controller;

import com.example.ana.domain.Person;
import com.example.ana.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class PersonController {

    @Autowired
    private PersonService personService;

    @RequestMapping("/persons")
    String getPersons(Model model) {
        List<Person> persons = personService.getAll();
        model.addAttribute("listOPeople", persons);
        return "view_people";
    }

    @GetMapping("/person")
    String getPerson(Model model) {
        return "new_person";
    }

    @PostMapping("/person")
    String addPerson(Person person, Model model) {
        personService.add(person);
        List<Person> persons = personService.getAll();
        model.addAttribute("listOPeople", persons);
        return "view_people";
    }

    @ExceptionHandler(value = Exception.class)
    public String handleDefaultErrors(final Exception exception, Model model) {
        System.out.println(exception);
        model.addAttribute("message", exception.getMessage());
        return "error_message";
    }

    @GetMapping("/login")
    String login() {
        return "login";
    }

    @RequestMapping("/loggedout")
    String logout(Model model) {
        List<Person> persons = personService.getAll();
        model.addAttribute("listOPeople", persons);
        return "view_people";
    }

    @GetMapping("/admins-only")
    String admins() {
        return "administration";
    }


}
