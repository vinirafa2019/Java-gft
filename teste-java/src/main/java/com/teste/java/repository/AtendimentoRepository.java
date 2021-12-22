package com.teste.java.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.teste.java.model.Atendimento;

public interface AtendimentoRepository extends JpaRepository<Atendimento, String>{

	

}
