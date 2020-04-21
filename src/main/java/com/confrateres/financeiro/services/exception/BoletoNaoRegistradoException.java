package com.confrateres.financeiro.services.exception;

public class BoletoNaoRegistradoException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	
	public BoletoNaoRegistradoException(String mensagem) {
		super(mensagem);
	}
	
	public BoletoNaoRegistradoException(String mensagem, Throwable causa) {
		super(mensagem, causa);
	}

}
