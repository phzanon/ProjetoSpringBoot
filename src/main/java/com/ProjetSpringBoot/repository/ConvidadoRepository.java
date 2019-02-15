package com.ProjetSpringBoot.repository;

import org.springframework.data.repository.CrudRepository;

import com.ProjetSpringBoot.models.Convidado;
import com.ProjetSpringBoot.models.Evento;

public interface ConvidadoRepository extends CrudRepository<Convidado, String>{
	Iterable<Convidado> findByEvento(Evento evento);
}
