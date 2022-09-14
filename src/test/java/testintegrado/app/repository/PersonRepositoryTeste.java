package testintegrado.app.repository;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.springframework.beans.factory.annotation.Autowired;

import testintegrado.app.abstrato.RepositoryTeste;
import testintegrado.app.entity.Person;

public class PersonRepositoryTeste extends RepositoryTeste {
    @Autowired
    private PersonRepository personRepository;
    @Test
    public void findAllReturnsJohnDoe() { // as defined in data.sql
        Person joao = new Person(null, "jao", 22);
        Person maria = new Person(null, "maria", 92);
        joao = personRepository.save(joao);
        maria = personRepository.save(maria);

        var owners = personRepository.findAll();
        Assertions.assertNotNull(owners);
        Assertions.assertEquals(owners.size(), 2);
        Assertions.assertEquals(owners.get(0).getAge(), 22);
        Assertions.assertEquals(owners.get(0).getName(), "jao");
        Assertions.assertEquals(owners.get(0).getId(), joao.getId());

        Assertions.assertEquals(owners.get(1).getAge(), 92);
        Assertions.assertEquals(owners.get(1).getName(), "maria");
        Assertions.assertEquals(owners.get(1).getId(), maria.getId());


    }
}
