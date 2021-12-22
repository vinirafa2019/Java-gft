package com.teste.java.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.teste.java.exception.AtendimentoException;
import com.teste.java.model.Atendimento;
import com.teste.java.model.Servicos;
import com.teste.java.repository.AtendimentoRepository;

@Service
public class AtendimentoService {

	@Autowired
	AtendimentoRepository atendimentoRepository;
	

	
	public List<Atendimento> listar(){
		List<Servicos> s;
		return atendimentoRepository.findAll();
		
	}
	
	public Atendimento salvar(Atendimento atendimento) {
			Optional<Atendimento> a = atendimentoRepository.findById(atendimento.getIdentificador_paciente());		
		return atendimentoRepository.save(atendimento);
	}
	
	public Optional<Atendimento> buscar(String identificador_paciente){
		Optional<Atendimento> atend = atendimentoRepository.findById(identificador_paciente);
		if (atend.isEmpty()) {
			throw new AtendimentoException("Atendimento nao encontrado.");
		}
		return atend;		
	}
	
	public void atualizarAtendimento(Atendimento atendimento) {
		verificaExistenciaAtendimento(atendimento);
		atendimentoRepository.save(atendimento);
	}
	
	public void deletarAtendimento(String codigo_atendimento) {
			atendimentoRepository.deleteById(codigo_atendimento);
	}	
	
	
	
	private void verificaExistenciaAtendimento(Atendimento aten) {
		buscar(aten.getIdentificador_paciente());
	}
	
}
