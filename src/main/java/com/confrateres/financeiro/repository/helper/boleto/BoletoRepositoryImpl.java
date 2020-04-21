package com.confrateres.financeiro.repository.helper.boleto;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;

import com.confrateres.financeiro.model.Boleto;

public class BoletoRepositoryImpl implements BoletoRepositoryQueries {

	@PersistenceContext
	private EntityManager manager;

	@Override
	public Boleto findBoletoPorRegLancamento(Long sqRegLancamento) {

		Boleto boleto = null;

		try {
			// Buscar Boleto no banco de dados
			StringBuilder jpql = new StringBuilder();
			jpql.append("from Boleto boleto where boleto.regLancamento.sqRegLancamento = :sqRegLancamento");

			boleto = manager.createQuery(jpql.toString(), Boleto.class)
					.setParameter("sqRegLancamento", sqRegLancamento)
					.getSingleResult();

		} catch (NoResultException e) {
			return null; // Se não encontrar o ministro retorna null.
		}

		return boleto;
	}

}
