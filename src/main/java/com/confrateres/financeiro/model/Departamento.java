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
@Table(name = "tb_dpt_departamento")
public class Departamento {
	
	@Id
	@Column(name = "dpt_sq_departamento")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long sqDepartamento;
	
	@NotBlank
	@Size(max = 20, message = "tamanho máximo de 20 caracteres")
	@Column(name = "dpt_ds_reduzido", length = 20)
	private String dsReduzido;
	
	@NotBlank
	@Size(max = 100, message = "tamanho máximo de 100 caracteres")
	@Column(name = "dpt_ds_departamento", length = 100) 
	private String dsDepartamento;
	
	@Column(name="auditoria_data")
	private LocalDateTime auditoriaData;
	
	@Column(name="auditoria_usuario", length=50)
	private String auditoriaUsuario;

	public Long getSqDepartamento() {
		return sqDepartamento;
	}

	public void setSqDepartamento(Long sqDepartamento) {
		this.sqDepartamento = sqDepartamento;
	}

	public String getDsReduzido() {
		return dsReduzido;
	}

	public void setDsReduzido(String dsReduzido) {
		this.dsReduzido = dsReduzido;
	}

	public String getDsDepartamento() {
		return dsDepartamento;
	}

	public void setDsDepartamento(String dsDepartamento) {
		this.dsDepartamento = dsDepartamento;
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
