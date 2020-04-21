package com.confrateres.financeiro.repository.helper.regLancamento;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.confrateres.financeiro.dto.RegLancamentoDTO;

public class RegLancamentoRepositoryImpl implements RegLancamentoRepositoryQueries {

	@PersistenceContext
	private EntityManager manager;
	
	@Override
	public List<RegLancamentoDTO> findAllLancamentosAbertos(Long sqMinistro) {
		
		StringBuilder sql = new StringBuilder();
		sql.append("select rgl.rgl_sq_reglancamento as sqRegLancamento ") 
				.append(",rgl.rgl_dt_vencimento as dtVencimento ") 
				.append(",rgl.rgl_vl_lancamento as vlLancamento ")
				.append(",if(vlPagamentos.vlTotalPago is null, rgl.rgl_vl_lancamento, (rgl.rgl_vl_lancamento - vlPagamentos.vlTotalPago) ) as vlSaldo ")
				.append(",tpl.tpl_ds_tipolancamento as dsLancamentoTipo ")
				.append(",ifnull(bol.bol_ds_url, '') as dsUrl ")
				.append("from tb_rgl_reglancamento rgl ")
				.append("left join( ") 
				.append("select sum(lan.lan_vl_pagamento) as vlTotalPago, lan.rgl_sq_reglancamento as sqRegLancamento ") 
				.append("from tb_lan_lancamento lan ")
				.append("left join tb_rcb_recibo rcb on rcb.rcb_sq_recibo = lan.rcb_sq_recibo ")
				.append("where rcb.rcb_dt_cancelado is null group by sqRegLancamento) as vlPagamentos on (sqRegLancamento = rgl.rgl_sq_reglancamento) ")
				.append("left join tb_min_ministro min on rgl.min_sq_ministro = min.min_sq_ministro ")
				.append("left join tb_tpl_tipolancamento tpl on rgl.tpl_sq_tipolancamento = tpl.tpl_sq_tipolancamento ")
				.append("left join tb_dpt_departamento dpt on min.dpt_sq_departamento = dpt.dpt_sq_departamento ")
				.append("left join tb_bol_boleto bol on bol.rgl_sq_reglancamento = rgl.rgl_sq_reglancamento ")
				.append("where ((rgl.rgl_vl_lancamento - vlPagamentos.vlTotalPago) is null or	(rgl.rgl_vl_lancamento - vlPagamentos.vlTotalPago) >= 0.01) ")
				.append("and rgl.rgl_dt_cancelado is null ")
				.append("and min.min_dt_excluido is null ")
				.append("and min.dpt_sq_departamento = 1 ")
				.append("and rgl.min_sq_ministro = :sqMinistro");
		
		// Fazer consulta de lançamentos pendentes
		@SuppressWarnings("unchecked")
		List<Object[]> resultObject = manager.createNativeQuery(sql.toString())
				.setParameter("sqMinistro", sqMinistro)
				.getResultList();
		
		// Criar lista vazia para armazenar retorno da consulta
		List<RegLancamentoDTO> regLancamentoDTO = new ArrayList<RegLancamentoDTO>();
		
		// Popular a lista que será retornada
		 DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		for(Object ob[] : resultObject) {
			RegLancamentoDTO regDTO = new RegLancamentoDTO();
			
			regDTO.setSqRegLancamento(Long.parseLong(ob[0].toString()));
			regDTO.setDtVencimento(LocalDate.parse(ob[1].toString(), formatter));
			regDTO.setVlLancamento(new BigDecimal(ob[2].toString()));
			regDTO.setVlSaldo(new BigDecimal(ob[3].toString()));
			regDTO.setDsLancamentoTipo(ob[4].toString());
			regDTO.setDsUrl(ob[5].toString());
			
			regLancamentoDTO.add(regDTO);
		}
		
		return regLancamentoDTO;
	}



}
