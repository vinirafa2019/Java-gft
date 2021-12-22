package com.teste.java.exception;

public class AtendimentoException extends RuntimeException{

	private static final long serialVersionUID = 1L;
	
	public AtendimentoException(String mensagem) {
		super(mensagem);
	}
}
