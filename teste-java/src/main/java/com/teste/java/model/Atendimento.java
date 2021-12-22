package com.teste.java.model;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
public class Atendimento {

	@Id
	private String identificador_paciente;
	
	private String tipo_atendimento;
	
	@JsonFormat(pattern = "dd/MM/yyyy HH:mm:ss")
	private LocalDateTime data_atendimento= LocalDateTime.now();
	
	private String local;
	
	@OneToMany
	@JoinColumn(name = "identificador_pac")
	private List<Servicos> servicos;

	public String getIdentificador_paciente() {
		return identificador_paciente;
	}

	public void setIdentificador_paciente(String identificador_paciente) {
		this.identificador_paciente = identificador_paciente;
	}

	public String getTipo_atendimento() {
		return tipo_atendimento;
	}

	public void setTipo_atendimento(String tipo_atendimento) {
		this.tipo_atendimento = tipo_atendimento;
	}

	public LocalDateTime getData_atendimento() {
		return data_atendimento;
	}

	public void setData_atendimento(LocalDateTime data_atendimento) {
		this.data_atendimento = data_atendimento;
	}

	public String getLocal() {
		return local;
	}

	public void setLocal(String local) {
		this.local = local;
	}

	public List<Servicos> getServicos() {
		return servicos;
	}

	public void setServicos(List<Servicos> servicos) {
		this.servicos = servicos;
	}




}
