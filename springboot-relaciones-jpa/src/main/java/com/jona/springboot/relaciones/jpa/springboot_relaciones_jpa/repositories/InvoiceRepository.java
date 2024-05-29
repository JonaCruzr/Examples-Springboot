package com.jona.springboot.relaciones.jpa.springboot_relaciones_jpa.repositories;

import org.springframework.data.repository.CrudRepository;

import com.jona.springboot.relaciones.jpa.springboot_relaciones_jpa.entities.Invoice;

public interface InvoiceRepository extends CrudRepository<Invoice, Long>{

}
