package testintegrado.app.controller;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import testintegrado.app.entity.Person;
import testintegrado.app.service.PersonService;

@RestController
@RequestMapping("/pessoas")
public class PersonControllers {

    @Autowired
    private PersonService personService;

    @GetMapping
    public List<Person> getAll(){
        return personService.findAllPersons();
    }
    @GetMapping("{id}")
    public Person getByID(UUID uuid){
        return personService.findPersonbyId(uuid);
    }
    @PostMapping
    public Person save(@RequestBody Person person){
        return personService.save(person);
    }
    @DeleteMapping
    public void delete(UUID uuid){
        personService.delete(uuid);
    }
}
