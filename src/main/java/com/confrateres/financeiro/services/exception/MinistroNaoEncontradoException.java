package com.confrateres.financeiro.services.exception;

public class MinistroNaoEncontradoException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	
	public MinistroNaoEncontradoException(String mensagem) {
		super(mensagem);
	}
	
	public MinistroNaoEncontradoException(String mensagem, Throwable causa) {
		super(mensagem, causa);
	}

}
