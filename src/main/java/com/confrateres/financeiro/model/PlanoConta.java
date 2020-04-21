package com.confrateres.financeiro.model;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "tb_plc_plano_contas")
public class PlanoConta {

	@Id
	@Column(name = "plc_sq_plano_contas")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long sqPlanoConta;
	
	@NotNull
	@Column(name = "plc_cd_conta", nullable = false)
	private Long cdConta;
	 
	@NotBlank
	@Size(max = 30, message = "tamanho máximo de 30 caracters")
	@Column(name = "plc_ds_conta", nullable = false, length= 30)
	private String dsConta;
	
	@NotBlank
	@Size(min = 1, max = 1, message = "deve ter 1 caracter")
	@Column(name = "plc_tp_conta", nullable = false, length = 1)
	private String tpConta;
	
	@Column(name="auditoria_data")
	private LocalDateTime auditoriaData;
	
	@Column(name="auditoria_usuario", length=50)
	private String auditoriaUsuario;

	public Long getSqPlanoConta() {
		return sqPlanoConta;
	}

	public void setSqPlanoConta(Long sqPlanoConta) {
		this.sqPlanoConta = sqPlanoConta;
	}

	public Long getCdConta() {
		return cdConta;
	}

	public void setCdConta(Long cdConta) {
		this.cdConta = cdConta;
	}

	public String getDsConta() {
		return dsConta;
	}

	public void setDsConta(String dsConta) {
		this.dsConta = dsConta;
	}

	public String getTpConta() {
		return tpConta;
	}

	public void setTpConta(String tpConta) {
		this.tpConta = tpConta;
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
