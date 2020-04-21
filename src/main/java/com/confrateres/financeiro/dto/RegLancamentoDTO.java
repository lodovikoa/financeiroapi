package com.confrateres.financeiro.dto;

import java.math.BigDecimal;
import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFormat;

public class RegLancamentoDTO {

	private Long sqRegLancamento;
	
	@JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate dtVencimento; 
	
	private BigDecimal vlLancamento; 
    private BigDecimal vlSaldo;   
    private String dsLancamentoTipo;
    
    private String dsUrl;

	public Long getSqRegLancamento() {
		return sqRegLancamento;
	}

	public void setSqRegLancamento(Long sqRegLancamento) {
		this.sqRegLancamento = sqRegLancamento;
	}

	public LocalDate getDtVencimento() {
		return dtVencimento;
	}
	
	public void setDtVencimento(LocalDate dtVencimento) {
		this.dtVencimento = dtVencimento;
	}

	public BigDecimal getVlLancamento() {
		return vlLancamento;
	}

	public void setVlLancamento(BigDecimal vlLancamento) {
		this.vlLancamento = vlLancamento;
	}

	public BigDecimal getVlSaldo() {
		return vlSaldo;
	}

	public void setVlSaldo(BigDecimal vlSaldo) {
		this.vlSaldo = vlSaldo;
	}

	public String getDsLancamentoTipo() {
		return dsLancamentoTipo;
	}

	public void setDsLancamentoTipo(String dsLancamentoTipo) {
		this.dsLancamentoTipo = dsLancamentoTipo;
	}
	
	public String getDsUrl() {
		return dsUrl;
	}
	
	public void setDsUrl(String dsUrl) {
		this.dsUrl = dsUrl;
	}
}
