package com.confrateres.financeiro.model;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
@Table(name="tb_est_estado")
public class Estado {

	@Id
	@Column(name="est_sq_estado")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long sqEstado;
	
	@NotBlank
	@Size(min = 2, max = 2, message = "deve ter 2 caracteres")
	@Column(name="est_ds_uf", nullable=false, length=2)
	private String dsUf;
	
	@NotBlank
	@Size(max = 50, message = "tamanho máximo de 50 caracteres")
	@Column(name="est_ds_nome", nullable=false, length=50)
	private String dsNome;
	
	@Column(name="auditoria_data")
	private LocalDateTime auditoriaData;
	
	@Column(name="auditoria_usuario", length=50)
	private String auditoriaUsuario;

	public Long getSqEstado() {
		return sqEstado;
	}

	public void setSqEstado(Long sqEstado) {
		this.sqEstado = sqEstado;
	}

	public String getDsUf() {
		return dsUf;
	}

	public void setDsUf(String dsUf) {
		this.dsUf = dsUf;
	}

	public String getDsNome() {
		return dsNome;
	}

	public void setDsNome(String dsNome) {
		this.dsNome = dsNome;
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
