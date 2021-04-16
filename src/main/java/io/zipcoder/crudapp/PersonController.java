package io.zipcoder.crudapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class PersonController {

    @Autowired
    private final PersonRepository personRepository;

    PersonController(PersonRepository repository) {
        this.personRepository = repository;
    }

    @PostMapping("/people")
    public Person createPerson(Person p) {

        return personRepository.save(p);
    }

    @GetMapping("/people/{id}")
    public Person getPerson(@PathVariable int id) {
        return personRepository.findOne(id);
    }

    @GetMapping("/people")
    public List<Person> getPersonList() {
        List<Person> outList = new ArrayList<>();
        for (Person p : personRepository.findAll()) {
            outList.add(p);
        }
        return outList;
    }

    @PutMapping("/people/{id}")
    public Person updatePerson(@PathVariable Integer id, Person p) {
        Person holder = personRepository.findOne(id);
        holder.setFirstName(p.firstName);
        holder.setLastName(p.lastName);
        return personRepository.save(holder);
    }

    @DeleteMapping("/people/{id}")
    public void deletePerson(@PathVariable int id) {
        personRepository.delete(id);
    }
}
