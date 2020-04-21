package com.confrateres.financeiro.services;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.confrateres.financeiro.dto.MinistroDTO;
import com.confrateres.financeiro.dto.RegLancamentoDTO;
import com.confrateres.financeiro.model.Ministro;
import com.confrateres.financeiro.repository.RegLancamentoRepository;
import com.confrateres.financeiro.services.exception.ParametrosMalFormatadoException;

@Service
public class RegLancamentoService implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Autowired
	MinistroService ministroService;
	
	@Autowired
	RegLancamentoRepository regLancamentoRepository;

	public MinistroDTO listarPendencias(Long codigoMinistro, String cpfMinistro,
			String dtNascimentoMinistro, String nomeMinistro) {
		
		LocalDate dtNascimento;
		// Parsing campo dtNascimentoMinistro de String para LocalDate
		try {
			 DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		     dtNascimento = LocalDate.parse(dtNascimentoMinistro, formatter);
		} catch (DateTimeParseException e) {
			throw new ParametrosMalFormatadoException("A data de Nascimento não está no fomato yyyy-MM-dd, favor corrigir.");
		}
		
		// Validar preenchimento dos parametros
		if(codigoMinistro == 0l || cpfMinistro == null || cpfMinistro.length() == 0 || dtNascimento == null || nomeMinistro == null || nomeMinistro.trim().isEmpty()) {
			throw new ParametrosMalFormatadoException("Verifique se todos os parametros estão corretamente preenchidos: codigoMinistro, cpfMinistro, dtNascimento e nomeMinistros.");
		}
		
		// Buscar o ministro na base de dados
		Ministro ministro = ministroService.findMinistroFiltro(codigoMinistro, cpfMinistro, dtNascimento, nomeMinistro);
	
		// Buscar lançamentos em aberto do ministro.
		List<RegLancamentoDTO> regLancamentoDTO = regLancamentoRepository.findAllLancamentosAbertos(ministro.getSqMinistro());
		
		// Montar o retorno
		MinistroDTO ministroDTO = new MinistroDTO();
		
		ministroDTO.setCdMinistro(ministro.getCdCodigo());
		ministroDTO.setDsCargo(ministro.getCargo().getDsCargo());
		ministroDTO.setDsEmail(ministro.getDsEmail());
		ministroDTO.setDsIgreja(ministro.getIgreja().getDsIgreja());
		ministroDTO.setNmNome(ministro.getNmNOme());
		ministroDTO.setRegLancamentoDTO(regLancamentoDTO);
		
		return ministroDTO;
	}

}
