package testintegrado.app.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import testintegrado.app.entity.Person;


@Repository
public interface PersonRepository extends JpaRepository<Person,UUID> {
    
}
