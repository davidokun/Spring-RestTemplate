package com.darsideofthedev.resttemplate.service;

import com.darsideofthedev.resttemplate.model.Person;

import java.util.List;
import java.util.Optional;

public interface PersonService {

    List<Person> getPersons();

    Optional<Person> getPersonById(int id);
}
