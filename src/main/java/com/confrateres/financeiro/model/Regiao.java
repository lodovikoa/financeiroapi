package com.confrateres.financeiro.model;

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

import org.springframework.data.annotation.Transient;

@Entity
@Table(name="tb_rgn_regiao")
public class Regiao {

	@Id
	@Column(name="rgn_sq_regiao")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long sqRegiao;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="con_sq_convencao", nullable=false)
	private Convencao convencao;
	
	@NotBlank
	@Column(name="rgn_ds_regiao")
	private String dsRegiao;
	
	@Column(name="auditoria_data")
	private LocalDateTime auditoriaData;
	
	@Column(name="auditoria_usuario", length=50)
	private String auditoriaUsuario;
	
	@Transient
	private boolean flSelecionado;

	public Long getSqRegiao() {
		return sqRegiao;
	}

	public void setSqRegiao(Long sqRegiao) {
		this.sqRegiao = sqRegiao;
	}

	public Convencao getConvencao() {
		return convencao;
	}

	public void setConvencao(Convencao convencao) {
		this.convencao = convencao;
	}

	public String getDsRegiao() {
		return dsRegiao;
	}

	public void setDsRegiao(String dsRegiao) {
		this.dsRegiao = dsRegiao;
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

	public boolean isFlSelecionado() {
		return flSelecionado;
	}

	public void setFlSelecionado(boolean flSelecionado) {
		this.flSelecionado = flSelecionado;
	}
}
