package com.confrateres.financeiro.services.exception;

public class ParametrosMalFormatadoException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	
	public ParametrosMalFormatadoException(String mensagem) {
		super(mensagem);
	}
	
	public ParametrosMalFormatadoException(String mensagem, Throwable causa) {
		super(mensagem, causa);
	}

}
