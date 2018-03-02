package com.darsideofthedev.resttemplate.client;


import com.darsideofthedev.resttemplate.model.Person;
import org.junit.Test;
import org.springframework.http.HttpEntity;
import org.springframework.web.client.RestTemplate;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertNotNull;
import static junit.framework.TestCase.assertTrue;

public class RestTemplateClientTest {

    private final String BASE_URL = "http://localhost:8686/v1/persons";
    private RestTemplate restTemplate = new RestTemplate();


    @Test
    public void getPersonByIdGetForObjectString(){

        String person = restTemplate.getForObject(BASE_URL + "/1", String.class);
        assertNotNull(person);
        assertTrue(person.contains("Jon"));
    }

    @Test
    public void getPersonByIdGetForObjectPersonClass(){

        Person person = restTemplate.getForObject(BASE_URL + "/1", Person.class);
        assertNotNull(person);
        assertEquals("Jon", person.getFirstName());
    }

    @Test
    public void createPeron(){
        Person newPerson = new Person(3, "Clark", "Kent", 33);
        HttpEntity<Person> requestBody = new HttpEntity<>(newPerson);

        Person person = restTemplate.postForObject(BASE_URL, requestBody, Person.class);

        assertNotNull(person);
        assertEquals("Kent", person.getLastName());
        assertEquals(33, person.getAge());
    }
}
