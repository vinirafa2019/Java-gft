package com.teste.java.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Servicos {

	
	@Id
	private Long id;
	
	private String descricao_procedimento;
	
	private double valor_servico;
	
	@JsonIgnore
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "servicos")
	private List<Atendimento> atendimentos;
	
	public String getDescricao_procedimento() {
		return descricao_procedimento;
	}

	public void setDescricao_procedimento(String descricao_procedimento) {
		this.descricao_procedimento = descricao_procedimento;
	}

	public double getValor_servico() {
		return valor_servico;
	}

	public void setValor_servico(double valor_servico) {
		this.valor_servico = valor_servico;
	}

	public List<Atendimento> getAtendimentos() {
		return atendimentos;
	}

	public void setAtendimentos(List<Atendimento> atendimentos) {
		this.atendimentos = atendimentos;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
}
