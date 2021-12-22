package com.teste.java.controller;


import java.net.URI;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.web.WebProperties.Resources.Cache.Cachecontrol;
import org.springframework.http.CacheControl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.teste.java.model.Atendimento;
import com.teste.java.model.Servicos;
import com.teste.java.service.AtendimentoService;

@RestController
@RequestMapping("/atendimentos")
public class AtendimentoController {

	@Autowired
	private AtendimentoService atendimentoService;
	
	@GetMapping
	public ResponseEntity<List<Atendimento>> listar() {
		return ResponseEntity.status(HttpStatus.OK).body(atendimentoService.listar());
	}
	
	@GetMapping(value = "paciente/{codigo-paciente}")
	public ResponseEntity<?> buscarPorCodigoPaciente(@PathVariable ("codigo-paciente") String identificador_paciente){
		Optional<Atendimento> atend = atendimentoService.buscar(identificador_paciente);
		
		CacheControl cachecontrol = CacheControl.maxAge(20, TimeUnit.SECONDS);
		
		return ResponseEntity.status(HttpStatus.OK).cacheControl(cachecontrol).body(atend);
	}
	
	@PostMapping(value = "/atendimento")
	public ResponseEntity<Void> salvar (@RequestBody Atendimento atendimento){
		atendimento = atendimentoService.salvar(atendimento);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/id").buildAndExpand(atendimento.getIdentificador_paciente()).toUri();
		return ResponseEntity.created(uri).build();
		
	}
	
	@PutMapping(value = "atendimento/{codigo-paciente}")
	public ResponseEntity<Void> alterarAtendimento(@RequestBody Atendimento atendimento, 
			@PathVariable("codigo-paciente") String identificador_paciente) {
		atendimento.setIdentificador_paciente(identificador_paciente);
		atendimentoService.atualizarAtendimento(atendimento);
		return ResponseEntity.ok().build();

	}
	
	@DeleteMapping(value = "atendimento/{codigo_atendimento}")
	public ResponseEntity<Void>removerAtendimento(@PathVariable ("codigo_atendimento")String codigo_atendimento){
		atendimentoService.deletarAtendimento(codigo_atendimento);
		return ResponseEntity.ok().build();
		
	}
	
}
