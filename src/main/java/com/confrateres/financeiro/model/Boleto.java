package com.confrateres.financeiro.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name="tb_bol_boleto")
public class Boleto {

	@Id
	@Column(name="bol_sq_boleto")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long sqBoleto;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "rgl_sq_reglancamento", nullable = false)
	private RegLancamento regLancamento;
	
	@Transient
	private List<RegLancamento> regLancamentos;
	
	@Column(name = "bol_ds_url") 
	private String dsUrl;

	public Long getSqBoleto() {
		return sqBoleto;
	}

	public void setSqBoleto(Long sqBoleto) {
		this.sqBoleto = sqBoleto;
	}
	
	public RegLancamento getRegLancamento() {
		return regLancamento;
	}
	
	public void setRegLancamento(RegLancamento regLancamento) {
		this.regLancamento = regLancamento;
	}

	public List<RegLancamento> getRegLancamentos() {
		return regLancamentos;
	}
	
	public void setRegLancamentos(List<RegLancamento> regLancamentos) {
		this.regLancamentos = regLancamentos;
	}
	
	public String getDsUrl() {
		return dsUrl;
	}

	public void setDsUrl(String dsUrl) {
		this.dsUrl = dsUrl;
	}
}
