package com.jona.springboot.relaciones.jpa.springboot_relaciones_jpa.repositories;

import org.springframework.data.repository.CrudRepository;

import com.jona.springboot.relaciones.jpa.springboot_relaciones_jpa.entities.Client;

public interface ClientRespository extends CrudRepository<Client, Long>{
    Client findByName(String name);
}
