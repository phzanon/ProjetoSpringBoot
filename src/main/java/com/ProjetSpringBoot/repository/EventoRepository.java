package com.ProjetSpringBoot.repository;

import org.springframework.data.repository.CrudRepository;

import com.ProjetSpringBoot.models.Evento;

public interface EventoRepository extends CrudRepository<Evento, String>{
	Evento findByCodigo(long codigo);
}
