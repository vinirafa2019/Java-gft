package com.teste.java.controller;


import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.teste.java.model.Atendimento;
import com.teste.java.model.Servicos;
import com.teste.java.service.AtendimentoService;
import com.teste.java.service.ServicoService;

@RestController
@RequestMapping("/servico")
public class ServicoController {

	@Autowired
	private ServicoService service;
	
	@GetMapping
	public ResponseEntity<List<Servicos>> listar() {
		return ResponseEntity.status(HttpStatus.OK).body(service.listar());
	}
	
	@PostMapping
	public ResponseEntity<Void> salvar (@RequestBody Servicos servicos){
		servicos = service.salvar(servicos);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/id").buildAndExpand(servicos.getDescricao_procedimento()).toUri();
		return ResponseEntity.created(uri).build();
		
	}
}
