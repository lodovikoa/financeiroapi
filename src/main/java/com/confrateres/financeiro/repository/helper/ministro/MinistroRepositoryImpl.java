package com.confrateres.financeiro.repository.helper.ministro;

import java.time.LocalDate;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;

import com.confrateres.financeiro.model.Ministro;

public class MinistroRepositoryImpl implements MinistroRepositoryQueries {

	@PersistenceContext
	private EntityManager manager;


	public Ministro findMinistroFiltro(Long codigoMinistro, String cpfMinistro, LocalDate dtNascimentoMinistro,
			String nomeMinistro) {

		Ministro ministro = null;
		try {

			// Preparar para buscar o nome informado do ministro em qualquer parte do nome e em qualquer ordem informada
			String nmNomeTemp[] = nomeMinistro.split(" ");

			StringBuilder strNome = new StringBuilder();
			for(int i = 0; i < nmNomeTemp.length; i++){
				if(nmNomeTemp[i].trim().length() > 0){
					strNome.append(" and");
					strNome.append(" ministro.nmNome like ");
					strNome.append("'%" +nmNomeTemp[i].trim() + "%'");
				}
			}

			// Buscar ministro no banco de dados
			StringBuilder jpql = new StringBuilder();

			jpql.append("from Ministro ministro ")
				.append("left join fetch ministro.cargo ")
				.append("left join fetch ministro.igreja ")
				.append("where ministro.cdCodigo = :codigoMinistro and ministro.dsCpf = :cpfMinistro and ministro.dtNascimento = :dtNascimentoMinistro ")
				.append(strNome.toString());

			ministro = manager.createQuery(jpql.toString(), Ministro.class)
					.setParameter("codigoMinistro", codigoMinistro)
					.setParameter("cpfMinistro", cpfMinistro)
					.setParameter("dtNascimentoMinistro", dtNascimentoMinistro)
					.getSingleResult();

		} catch (NoResultException e) {
			return null; // Se não encontrar o ministro retorna null.
		}
		return  ministro;
	}

}
