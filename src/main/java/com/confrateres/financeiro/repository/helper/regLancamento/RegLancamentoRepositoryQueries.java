package com.confrateres.financeiro.repository.helper.regLancamento;

import java.util.List;

import com.confrateres.financeiro.dto.RegLancamentoDTO;

public interface RegLancamentoRepositoryQueries {

	public List<RegLancamentoDTO> findAllLancamentosAbertos(Long sqMinistro);
}
