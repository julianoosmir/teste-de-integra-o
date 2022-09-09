package testintegrado.app.repository;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.PropertySource;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;
import testintegrado.app.entity.Person;

@DataJpaTest
@RunWith(SpringRunner.class)
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@TestPropertySource(properties = {"spring.datasource.url=jdbc:postgresql://localhost:5432/teste"})
public class PersonRepositoryTeste {
    @Autowired
    private PersonRepository personRepository;
    @Test
    public void findAllReturnsJohnDoe() { // as defined in tc-initscript.sql
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
