package com.confrateres.financeiro.services;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.confrateres.financeiro.model.Ministro;
import com.confrateres.financeiro.repository.MinistroRepository;
import com.confrateres.financeiro.services.exception.MinistroNaoEncontradoException;

@Service
public class MinistroService {

	@Autowired
	MinistroRepository ministroRepository;
	
	public Ministro findMinistroFiltro(Long codigoMinistro, String cpfMinistro,
			LocalDate dtNascimentoMinistro, String nomeMinistro) {
		
		Ministro ministro = ministroRepository.findMinistroFiltro(codigoMinistro, cpfMinistro, dtNascimentoMinistro, nomeMinistro);
		
		// Se não encontrar ministro com os parametros informados dispara excessao
		if(ministro == null) {
			throw new MinistroNaoEncontradoException("Ministro não localizado com os parametros informados.");
		}
		
		return ministro;
	}
}
