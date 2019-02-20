package com.ProjetSpringBoot.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ProjetSpringBoot.models.Evento;
import com.ProjetSpringBoot.repository.EventoRepository;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/consulta")
@Api(value="Eventos", description="Api Para manipulação de Eventos")
public class RestApiController {
	
	@Autowired
	private EventoRepository er;
	
	@ApiOperation(value="Lista de Eventos Cadastrados no Banco", response = Iterable.class)
	@ApiResponses(value = {
			@ApiResponse(code = 200, message="Successfully retrieved list"),
			@ApiResponse(code = 401, message="You are not authorized to view the resource"),
			@ApiResponse(code = 403, message="Accessing the resource you were trying to reach is forbidden"),
			@ApiResponse(code = 404, message="The resource you were trying to reach is not found")
	})
	@RequestMapping(value="/list")
	public Iterable<Evento> listaEventos() {
		Iterable<Evento> lista = er.findAll();
		return lista;
	}

}
