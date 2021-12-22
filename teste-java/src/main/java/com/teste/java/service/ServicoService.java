package com.teste.java.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.teste.java.model.Atendimento;
import com.teste.java.model.Servicos;
import com.teste.java.repository.AtendimentoRepository;
import com.teste.java.repository.ServicoRepository;

@Service
public class ServicoService {

	@Autowired
	ServicoRepository repository;
	

	
	public List<Servicos> listar(){
		List<Servicos> s;
		return repository.findAll();
		
	}
	
	public Servicos salvar(Servicos servicos) {
			Optional<Servicos> a = repository.findById(servicos.getId());		
		return repository.save(servicos);
	}
	
}
