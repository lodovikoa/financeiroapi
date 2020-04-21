package com.confrateres.financeiro.repository.helper.boleto;

import com.confrateres.financeiro.model.Boleto;

public interface BoletoRepositoryQueries {

	public Boleto findBoletoPorRegLancamento(Long sqRegLancamento);
}
