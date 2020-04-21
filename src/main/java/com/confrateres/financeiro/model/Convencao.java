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
import javax.validation.constraints.Size;

@Entity
@Table(name="tb_con_convencao")
public class Convencao {

	@Id
	@Column(name="con_sq_convencao")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long sqConvencao;
	
	@NotBlank
	@Size(max = 20, message = "tamanho máximo de 20 caracteres")
	@Column(name="con_ds_reduzido", nullable=false, length=20)
	private String dsReduzido;
	
	@NotBlank
	@Size(max = 100, message = "tamanho máximo de 100 caracteres")
	@Column(name="con_ds_convencao", nullable=false, length=100)
	private String dsConvencao;

	@Column(name="con_im_logo", length=100)
	private String imLogo;
	
	@Size(max = 100, message = "tamanho máximo de 100 caracteres")
	@Column(name="con_ds_endereco", length=100)
	private String dsEndereco;
	
	@Size(max = 100, message = "tamanho máximo de 100 caracteres")
	@Column(name="con_ds_bairro", length=100)
	private String dsBairro;
	
	@Size(max = 100, message = "tamanho máximo de 100 caracteres")
	@Column(name="con_ds_cidade", length=100)
	private String dsCidade;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="est_sq_estado", nullable=false)
	private Estado estado;
	
	@Size(max = 100, message = "tamanho máximo de 100 caracteres")
	@Column(name="con_ds_pais", length=50)
	private String dsPais;
	
	@Column(name="con_ds_cep", length=8)
	private String dsCep;
	
	@Column(name="con_ds_cnpj", length=14)
	private String dsCnpj;
	
	@Column(name="auditoria_data")
	private LocalDateTime auditoriaData;
	
	@Column(name="auditoria_usuario", length=50)
	private String auditoriaUsuario;

	public Long getSqConvencao() {
		return sqConvencao;
	}

	public void setSqConvencao(Long sqConvencao) {
		this.sqConvencao = sqConvencao;
	}

	public String getDsReduzido() {
		return dsReduzido;
	}

	public void setDsReduzido(String dsReduzido) {
		this.dsReduzido = dsReduzido;
	}

	public String getDsConvencao() {
		return dsConvencao;
	}

	public void setDsConvencao(String dsConvencao) {
		this.dsConvencao = dsConvencao;
	}

	public String getImLogo() {
		return imLogo;
	}

	public void setImLogo(String imLogo) {
		this.imLogo = imLogo;
	}

	public String getDsEndereco() {
		return dsEndereco;
	}

	public void setDsEndereco(String dsEndereco) {
		this.dsEndereco = dsEndereco;
	}

	public String getDsBairro() {
		return dsBairro;
	}

	public void setDsBairro(String dsBairro) {
		this.dsBairro = dsBairro;
	}

	public String getDsCidade() {
		return dsCidade;
	}

	public void setDsCidade(String dsCidade) {
		this.dsCidade = dsCidade;
	}

	public Estado getEstado() {
		return estado;
	}

	public void setEstado(Estado estado) {
		this.estado = estado;
	}

	public String getDsPais() {
		return dsPais;
	}

	public void setDsPais(String dsPais) {
		this.dsPais = dsPais;
	}

	public String getDsCep() {
		return dsCep;
	}

	public void setDsCep(String dsCep) {
		this.dsCep = dsCep;
	}

	public String getDsCnpj() {
		return dsCnpj;
	}

	public void setDsCnpj(String dsCnpj) {
		this.dsCnpj = dsCnpj;
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
