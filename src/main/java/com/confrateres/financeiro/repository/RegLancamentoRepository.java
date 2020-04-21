package com.confrateres.financeiro.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.confrateres.financeiro.model.RegLancamento;
import com.confrateres.financeiro.repository.helper.regLancamento.RegLancamentoRepositoryQueries;

@Repository
public interface RegLancamentoRepository extends JpaRepository<RegLancamento, Long>, RegLancamentoRepositoryQueries {

}
