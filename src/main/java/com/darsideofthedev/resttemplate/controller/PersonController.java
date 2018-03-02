package com.darsideofthedev.resttemplate.controller;

import com.darsideofthedev.resttemplate.model.Person;
import com.darsideofthedev.resttemplate.service.impl.PersonServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("v1")
public class PersonController {

    private final PersonServiceImpl personService;

    @Autowired
    public PersonController(PersonServiceImpl personService) {
        this.personService = personService;
    }

    @GetMapping(value = "persons", produces = MediaType.APPLICATION_XML_VALUE)
    public ResponseEntity<List<Person>> getPersons(){

        return ResponseEntity.ok(personService.getPersons());
    }

    @GetMapping(value = "persons/{id}", produces = MediaType.APPLICATION_XML_VALUE)
    public ResponseEntity<Person> getPersonById(@PathVariable int id) {

        return ResponseEntity.ok(personService.getPersonById(id).orElse(new Person()));
    }
}
