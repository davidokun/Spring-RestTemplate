package com.darsideofthedev.resttemplate.service.impl;

import com.darsideofthedev.resttemplate.model.Person;
import com.darsideofthedev.resttemplate.service.PersonService;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Service
public class PersonServiceImpl implements PersonService {

    private static List<Person> personList = new ArrayList<>();

    @PostConstruct
    public void setUp() {
        personList.add(new Person(1, "Jon", "Doe", 23));
        personList.add(new Person(2, "Jane", "Doe", 26));
    }


    @Override
    public List<Person> getPersons() {
        return personList;
    }

    @Override
    public Person getPersonById(int id) {
        return personList.get(id);
    }
}
