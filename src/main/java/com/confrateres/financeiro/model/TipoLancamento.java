package com.confrateres.financeiro.model;

import java.math.BigDecimal;
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
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "tb_tpl_tipolancamento")
public class TipoLancamento {

	@Id
	@Column(name = "tpl_sq_tipolancamento")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long sqTipoLancamento;
	
	@NotBlank
	@Size(max = 40, message = "tamanho máximo de 40 caracteres")
	@Column(name = "tpl_ds_tipolancamento", nullable = false, length = 40) 
	private String dsTipoLancamento;
	
	@NotNull
	@Column(name="tpl_vl_tipolancamento", nullable = false, precision = 10, scale = 2)
	private BigDecimal vlTipoLancamento;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "plc_sq_plano_contas", nullable = false)
	private PlanoConta planoConta;
	
	@Column(name="auditoria_data")
	private LocalDateTime auditoriaData;
	
	@Column(name="auditoria_usuario", length=50)
	private String auditoriaUsuario;

	public Long getSqTipoLancamento() {
		return sqTipoLancamento;
	}

	public void setSqTipoLancamento(Long sqTipoLancamento) {
		this.sqTipoLancamento = sqTipoLancamento;
	}

	public String getDsTipoLancamento() {
		return dsTipoLancamento;
	}

	public void setDsTipoLancamento(String dsTipoLancamento) {
		this.dsTipoLancamento = dsTipoLancamento;
	}

	public BigDecimal getVlTipoLancamento() {
		return vlTipoLancamento;
	}

	public void setVlTipoLancamento(BigDecimal vlTipoLancamento) {
		this.vlTipoLancamento = vlTipoLancamento;
	}

	public PlanoConta getPlanoConta() {
		return planoConta;
	}

	public void setPlanoConta(PlanoConta planoConta) {
		this.planoConta = planoConta;
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
