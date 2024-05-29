package com.jona.springboot.relaciones.jpa.springboot_relaciones_jpa;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.jona.springboot.relaciones.jpa.springboot_relaciones_jpa.entities.Client;
import com.jona.springboot.relaciones.jpa.springboot_relaciones_jpa.entities.Invoice;
import com.jona.springboot.relaciones.jpa.springboot_relaciones_jpa.repositories.ClientRespository;
import com.jona.springboot.relaciones.jpa.springboot_relaciones_jpa.repositories.InvoiceRepository;

import jakarta.transaction.Transactional;

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
public class SpringbootRelacionesJpaApplication implements CommandLineRunner {

	@Autowired
	private ClientRespository clientRespository;
	
	@Autowired
	private InvoiceRepository invoiceRepository;

	public static void main(String[] args) {
		SpringApplication.run(SpringbootRelacionesJpaApplication.class, args);
	}

	/*
	 * Cuando una clase implementa CommandLineRunner, Spring Boot garantiza que el método "run" 
	 * se ejecutará una vez que el contexto de la aplicación se haya inicializado completamente
	 */

	 @Override
	 public void run(String... args) throws Exception {
		//manyToOne();
		manyToOneFindById();
	 }

	 @Transactional
	 private void manyToOne() {
		Client client1 = new Client("Jona", "Cruz");
		clientRespository.save(client1);
 
		Invoice invoice1 = new Invoice("Compras de oficina", 2000L);
		invoice1.setClient(client1);
		Invoice invoiceDB = invoiceRepository.save(invoice1);
		System.out.println(invoiceDB);
	 }

	 @Transactional
	 private void manyToOneFindById() {
		Optional<Client> clientOptional = clientRespository.findById(2L);
		
		if(clientOptional.isPresent()){
			Client client1 = clientOptional.orElseThrow();
			Invoice invoice1 = new Invoice("Compras de la casa", 500L);
			invoice1.setClient(client1);
			Invoice invoiceDB = invoiceRepository.save(invoice1);
			System.out.println(invoiceDB);
		}
	 }
	 
	}
