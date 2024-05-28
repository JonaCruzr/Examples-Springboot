package com.jonathan.springboot.jpa.springbootjpa.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.jonathan.springboot.jpa.springbootjpa.entities.Person;
import java.util.List;


public interface PersonRepository extends CrudRepository<Person, Long>{

    List<Person> findByProgrammingLanguage(String programmingLanguage);

    
    
    @Query("select p from Person p where p.programmingLanguage=?1 and p.name=?2")
    List<Person> buscarUsersByLanguage(String programmingLanguage, String name);
}
