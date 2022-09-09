package testintegrado.app.service;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import testintegrado.app.entity.Person;
import testintegrado.app.repository.PersonRepository;


@Service
public class PersonService {

    @Autowired
    private PersonRepository personRepository;

    public List<Person> findAllPersons() {
        return personRepository.findAll();
    }

    public Person findPersonbyId(UUID uuid) {
        return personRepository.findById(uuid).get();
    }

    public Person save(Person person){
        return personRepository.save(person);
    }

    public void delete(UUID uuid) {
        personRepository.deleteById(uuid);
    }
}
