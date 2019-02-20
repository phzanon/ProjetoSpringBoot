/*package com.ProjetSpringBoot.controllers;

import java.util.ArrayList;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.ProjetSpringBoot.models.Convidado;
import com.ProjetSpringBoot.models.Evento;
import com.ProjetSpringBoot.repository.ConvidadoRepository;
import com.ProjetSpringBoot.repository.EventoRepository;

@Controller
public class EventoController {
	
	@Autowired
	private EventoRepository er;
	
	@Autowired
	private ConvidadoRepository cr;
	
	@RequestMapping(value="/cadastrarEvento", method=RequestMethod.GET)
	public String form() {
		return "evento/formEvento";
	}
	
	@RequestMapping(value="/cadastrarEvento", method=RequestMethod.POST)
	public String form(@Valid Evento evento, BindingResult result, RedirectAttributes attributes) {
		
		if(result.hasErrors()) {
			attributes.addFlashAttribute("mensagem", "Verifique os campos");
			return "redirect:/cadastrarEvento";
		}
		
		
		er.save(evento);
		attributes.addFlashAttribute("mensagem", "Evento Cadastrado com sucesso!");
		
		return "redirect:/cadastrarEvento";
	}
	
	@RequestMapping("/evento")
	public ModelAndView listaEventos() { 
		ModelAndView mv = new ModelAndView("index");
		Iterable<Evento> eventos = er.findAll();
		mv.addObject("eventos",eventos);
		return mv;
	}
	
	@RequestMapping(value="/{codigo}", method=RequestMethod.GET)
	public ModelAndView detalhesEventos(@PathVariable("codigo") long codigo) {
		Evento evento = er.findByCodigo(codigo);
		ModelAndView mv = new ModelAndView("evento/detalhesEvento");
		mv.addObject("evento", evento);
		
		Iterable<Convidado> convidados = cr.findByEvento(evento);
		mv.addObject("convidados", convidados);
		return mv;
	}
	
	@RequestMapping(value="/deletarEvento") 
	public String deletarEvento(long codigo) {
		Evento evento = er.findByCodigo(codigo);
		
		Iterable<Convidado> convidados =  cr.findByEvento(evento);
		
		for(Convidado convidado : convidados) {
			cr.delete(convidado);
		}
		
		er.delete(evento);
		return "redirect:/evento";
	}
	 
	
	
	
	@RequestMapping(value="/{codigo}", method=RequestMethod.POST)
	public String detalhesEvento(@PathVariable("codigo") long codigo, @Valid Convidado convidado, BindingResult result, RedirectAttributes attributes) {
		
		if(result.hasErrors()) {
			attributes.addFlashAttribute("mensagem", "Verifique os campos");
			return "redirect:/{codigo}";
		}
		
		
		Evento evento = er.findByCodigo(codigo); 
		convidado.setEvento(evento);
		cr.save(convidado);
		attributes.addFlashAttribute("mensagem", "Convidado adicionado com sucesso!");
		return "redirect:/{codigo}";
	}
	
	@RequestMapping(value="/apagar")
	public String apagar(String rg) { 
		Convidado convidado = cr.findByrg(rg); 
		long numeroEvento = convidado.getEvento().getCodigo();
		String teste = ""+numeroEvento;
		cr.delete(convidado);
		return "redirect:/evento/"+teste; 
	}
}
*/