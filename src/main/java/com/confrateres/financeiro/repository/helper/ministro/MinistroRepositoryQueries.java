package com.confrateres.financeiro.repository.helper.ministro;

import java.time.LocalDate;

import com.confrateres.financeiro.model.Ministro;

public interface MinistroRepositoryQueries {

	public Ministro findMinistroFiltro(Long codigoMinistro, String cpfMinistro,
			LocalDate dtNascimentoMinistro, String nomeMinistro);	
}
