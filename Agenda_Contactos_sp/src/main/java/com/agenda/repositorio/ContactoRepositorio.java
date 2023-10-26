package com.agenda.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;

import com.agenda.modelo.Contacto;



public interface ContactoRepositorio extends JpaRepository<Contacto, Integer> {

	
}
