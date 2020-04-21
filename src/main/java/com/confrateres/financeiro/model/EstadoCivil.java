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
@Table(name = "tb_civ_estadocivel")
public class EstadoCivil {

	@Id
	@Column(name = "civ_sq_estadocivel")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long sqEstadoCivel;
	
	@NotBlank
	@Size(max = 30, message = "tamanho máximo de 30 caracteres")
	@Column(name = "civ_ds_estadocivel", nullable = false, length = 30) 
	private String dsEstadoCivel;
	
	@Column(name="auditoria_data")
	private LocalDateTime auditoriaData;
	
	@Column(name="auditoria_usuario", length=50)
	private String auditoriaUsuario;

	public Long getSqEstadoCivel() {
		return sqEstadoCivel;
	}

	public void setSqEstadoCivel(Long sqEstadoCivel) {
		this.sqEstadoCivel = sqEstadoCivel;
	}

	public String getDsEstadoCivel() {
		return dsEstadoCivel;
	}

	public void setDsEstadoCivel(String dsEstadoCivel) {
		this.dsEstadoCivel = dsEstadoCivel;
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
