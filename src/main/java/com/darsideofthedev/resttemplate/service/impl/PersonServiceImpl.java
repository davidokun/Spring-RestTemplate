package com.darsideofthedev.resttemplate.service.impl;

import com.darsideofthedev.resttemplate.model.Hobbies;
import com.darsideofthedev.resttemplate.model.Hobby;
import com.darsideofthedev.resttemplate.model.Person;
import com.darsideofthedev.resttemplate.service.PersonService;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PersonServiceImpl implements PersonService {

    private static List<Person> personList = new ArrayList<>();

    @PostConstruct
    public void setUp() {
        Hobbies hobbies = new Hobbies();

        List<Hobby> hobbys = new ArrayList<>();
        hobbys.add(new Hobby("Movies"));
        hobbys.add(new Hobby("Sports"));

        hobbies.setHobbies(hobbys);

        personList.add(new Person(1, "Jon", "Doe", 23, hobbies));
        personList.add(new Person(2, "Jane", "Doe", 26, hobbies));
    }


    @Override
    public List<Person> getPersons() {
        return personList;
    }

    @Override
    public Optional<Person> getPersonById(int id) {
        return personList.stream()
                .filter(p -> p.getId() == id)
                .findFirst();
    }

    @Override
    public Person createPerson(Person person) {
        personList.add(person);
        return getPersonById(person.getId()).orElse(new Person());
    }
}
