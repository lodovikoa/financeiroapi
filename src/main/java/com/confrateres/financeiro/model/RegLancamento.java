package com.confrateres.financeiro.model;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="tb_rgl_reglancamento")
public class RegLancamento {

	@Id
	@Column(name="rgl_sq_reglancamento")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long sqRegLancamento;
	
	@Column(name = "rgl_cd_origem")
	private Integer cdOrigem;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "min_sq_ministro", nullable = false)
	private Ministro ministro;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "tpl_sq_tipolancamento", nullable = false)
	private TipoLancamento tipoLancamento;
	
	@Column(name = "rgl_dt_registro")
	private LocalDateTime dtRegistro;
	
	@Column(name = "rgl_dt_vencimento")
	private LocalDate dtVencimento;
	
	@Column(name="rgl_vl_lancamento", nullable = false, precision = 10, scale = 2)
	private BigDecimal vlLancamento;

	@Column(name = "rgl_dt_cancelado")
	private LocalDateTime dtCancelado;
	
	@Column(name="auditoria_data")
	private LocalDateTime auditoriaData;
	
	@Column(name="auditoria_usuario", length=50)
	private String auditoriaUsuario;

	public Long getSqRegLancamento() {
		return sqRegLancamento;
	}

	public void setSqRegLancamento(Long sqRegLancamento) {
		this.sqRegLancamento = sqRegLancamento;
	}

	public Integer getCdOrigem() {
		return cdOrigem;
	}

	public void setCdOrigem(Integer cdOrigem) {
		this.cdOrigem = cdOrigem;
	}

	public Ministro getMinistro() {
		return ministro;
	}

	public void setMinistro(Ministro ministro) {
		this.ministro = ministro;
	}

	public TipoLancamento getTipoLancamento() {
		return tipoLancamento;
	}

	public void setTipoLancamento(TipoLancamento tipoLancamento) {
		this.tipoLancamento = tipoLancamento;
	}

	public LocalDateTime getDtRegistro() {
		return dtRegistro;
	}

	public void setDtRegistro(LocalDateTime dtRegistro) {
		this.dtRegistro = dtRegistro;
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

	public LocalDateTime getDtCancelado() {
		return dtCancelado;
	}

	public void setDtCancelado(LocalDateTime dtCancelado) {
		this.dtCancelado = dtCancelado;
	}

	public LocalDateTime getAuditoriaData() {
		return auditoriaData;
	}

	public void setAuditoriaData(LocalDateTime auditoriaData) {
		this.auditoriaData = auditoriaData;
	}

	public String getAuditoriaUsuario() {
		return auditoriaUsuario;
	}

	public void setAuditoriaUsuario(String auditoriaUsuario) {
		this.auditoriaUsuario = auditoriaUsuario;
	}
}
