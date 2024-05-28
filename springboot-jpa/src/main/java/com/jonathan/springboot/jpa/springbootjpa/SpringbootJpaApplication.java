package com.jonathan.springboot.jpa.springbootjpa;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.jonathan.springboot.jpa.springbootjpa.entities.Person;
import com.jonathan.springboot.jpa.springbootjpa.repositories.PersonRepository;


/*
 * CommandLineRunner se utiliza para ejecutar un bloque de código específico después de que el contexto de
 * la aplicación se ha inicializado completamente. 
 * 
 * Implementar CommandLineRunner permite ejecutar código adicional cuando la aplicación se inicia
 * 
 * Puede ser útil en una variedad de casos, tales como inicializar datos en una base de datos, 
 * ejecutar tareas de configuración, o lanzar procesos secundarios.
 */
@SpringBootApplication
public class SpringbootJpaApplication implements CommandLineRunner{

	@Autowired
	private PersonRepository repository;

	public static void main(String[] args) {
		SpringApplication.run(SpringbootJpaApplication.class, args);
	}

	/*
	 * Cuando una clase implementa CommandLineRunner, Spring Boot garantiza que el método "run" 
	 * se ejecutará una vez que el contexto de la aplicación se haya inicializado completamente
	 */

	@Override
	public void run(String... args) throws Exception {
		create();
	}

	public void create(){
		Person person = new Person(null, "David", "Segundo", "Node");
		Person newPerson = repository.save(person);
		System.out.println(newPerson);
	}

	public void findOne(){
		Person person = null;
		Optional<Person> optionalPerson = repository.findById(8L);
		if(optionalPerson.isPresent()) {
			person = optionalPerson.get();
		}
		System.out.println(person);
	}

	public void list(){
		//List<Person> persons = (List<Person>) repository.findAll();
		//List<Person> persons = repository.findByProgrammingLanguage("Java");
		List<Person> persons = repository.buscarUsersByLanguage("Java", "Maria");
		persons.stream().forEach(person -> {
			System.out.println(person);
		});
	}

}
