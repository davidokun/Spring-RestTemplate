package com.darsideofthedev.resttemplate.service;

import com.darsideofthedev.resttemplate.model.Person;

import java.util.List;

public interface PersonService {

    List<Person> getPersons();

    Person getPersonById(int id);
}
