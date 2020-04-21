package com.confrateres.financeiro.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.confrateres.financeiro.model.Boleto;
import com.confrateres.financeiro.repository.helper.boleto.BoletoRepositoryQueries;

@Repository
public interface BoletoRepository extends JpaRepository<Boleto, Long>, BoletoRepositoryQueries {

}
