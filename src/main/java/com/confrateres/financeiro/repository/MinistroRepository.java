package com.confrateres.financeiro.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.confrateres.financeiro.model.Ministro;
import com.confrateres.financeiro.repository.helper.ministro.MinistroRepositoryQueries;

@Repository
public interface MinistroRepository extends JpaRepository<Ministro, Long>, MinistroRepositoryQueries  {

}
