package com.example.person;

import com.example.person.dto.CreatePerson;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(path = "/person")
public class PersonController {
    private final PersonRepository personRepository;

    public PersonController(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    @PostMapping(path = "/create")
    public @ResponseBody Person addNewPerson(@RequestBody CreatePerson createPerson) {
        Person person = new Person();
        person.setFirstName(createPerson.firstName());
        person.setLastName(createPerson.lastName());
        personRepository.save(person);
        return person;
    }

    @GetMapping(path = "/all")
    public @ResponseBody Page<Person> getAllPeople() {
        PageRequest limit = PageRequest.of(0, 100);
        return personRepository.findAll(limit);
    }

    @GetMapping(path = "/that")
    public @ResponseBody Iterable<Person> getThatPerson() {
        return personRepository.findThatPerson();
    }
}
