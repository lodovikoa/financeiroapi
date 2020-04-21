package com.confrateres.financeiro.handler;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.confrateres.financeiro.model.DetalhesErro;
import com.confrateres.financeiro.services.exception.BoletoNaoRegistradoException;
import com.confrateres.financeiro.services.exception.MinistroNaoEncontradoException;
import com.confrateres.financeiro.services.exception.ParametrosMalFormatadoException;

@ControllerAdvice
public class ResourceExceptionHandler {
	
	// Ao encontrar uma data mal formatada, o código é desviado para este método
	@ExceptionHandler(ParametrosMalFormatadoException.class)
	public ResponseEntity<DetalhesErro> handlerDataMalFormatada(ParametrosMalFormatadoException e, HttpServletRequest request) {
		
		DetalhesErro erro = new DetalhesErro();
		erro.setStatus(400l);
		erro.setTitulo(e.getMessage());
		erro.setMensagemDesenvolvedor("Verifique os parametros, pois há parametro inválido");
		erro.setTimestamp(System.currentTimeMillis());
		
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(erro); // Retorna http status 400 + detalhes do erro
	}
	
	// Caso o ministro nao for encontrado o código é desviado para este método
	@ExceptionHandler(MinistroNaoEncontradoException.class)
	public ResponseEntity<DetalhesErro> handlerMinistroNaoEncontrado(MinistroNaoEncontradoException e, HttpServletRequest request) {
		
		DetalhesErro erro = new DetalhesErro();
		erro.setStatus(404l);
		erro.setTitulo(e.getMessage());
		erro.setMensagemDesenvolvedor("Ministro não encontrado com os parametros informados");
		erro.setTimestamp(System.currentTimeMillis());
		
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(erro); // Retorna http status 404 + detalhes do erro
	}
	
	public ResponseEntity<DetalhesErro> handlerBoletoNaoRegistrado(BoletoNaoRegistradoException e, HttpServletRequest request) {
		DetalhesErro erro = new DetalhesErro();
		erro.setStatus(400l);
		erro.setTitulo(e.getMessage());
		erro.setMensagemDesenvolvedor("Erro ao tentar registrar boletos na base da CONFRATERES. Operação falhou. Verifique seu email e informe ao Tesoureiro da CONFRATERES.");
		erro.setTimestamp(System.currentTimeMillis());
		
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(erro); // Retorna http status 404 + detalhes do erro
	}

}
