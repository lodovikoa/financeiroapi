package com.confrateres.financeiro.model;

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
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "tb_igr_igreja")
public class Igreja {

	@Id
	@Column(name = "igr_sq_igreja")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long sqIgreja;
	
	@NotNull
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "rgn_sq_regiao", nullable=false)
	private Regiao regiao; 
	
	@Size(max = 100, message = "tamanho máximo de 100 caracteres")
	@Column(name = "igr_ds_igreja", nullable=false)
	private String dsIgreja;
	
	@Transient
	private String dsIgrejaInvertida;
	

	@Column(name = "igr_ds_cnpj", length = 14)
	private String dsCnpj;
	
	@Column(name = "igr_dt_aniversario") 
	private LocalDate dtAniversario;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "min_sq_ministro", nullable = false) 
	private Ministro ministro;
	
	@Size(max = 100, message = "tamanho máximo de 100 caracteres")
	@Column(name = "igr_ds_endereco") 
	private String dsEndereco;
	
	@Size(max = 100, message = "tamanho máximo de 100 caracteres")
	@Column(name = "igr_ds_bairro") 
	private String dsBairro;
	
	@Size(max = 100, message = "tamanho máximo de 100 caracteres")
	@Column(name = "igr_ds_cidade") 
	private String dsCidade;
	
	
	@Column(name = "igr_ds_cep", length = 8) 
	private String dsCep;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="est_sq_estado", nullable=false)
	private Estado estado;
	
	@Column(name = "igr_ds_email") 
	private String dsEmail;

	@Column(name="auditoria_data")
	private LocalDateTime auditoriaData;
	
	@Column(name="auditoria_usuario", length=50)
	private String auditoriaUsuario;
	
	@Transient
	private String dsCnpjComMascara;
	
	@Transient
	private String dsCepComMascara;

	public Long getSqIgreja() {
		return sqIgreja;
	}

	public void setSqIgreja(Long sqIgreja) {
		this.sqIgreja = sqIgreja;
	}

	public Regiao getRegiao() {
		return regiao;
	}

	public void setRegiao(Regiao regiao) {
		this.regiao = regiao;
	}

	public String getDsIgreja() {
		return dsIgreja;
	}

	public void setDsIgreja(String dsIgreja) {
		this.dsIgreja = dsIgreja;
	}

	public String getDsIgrejaInvertida() {
		return dsIgrejaInvertida;
	}

	public void setDsIgrejaInvertida(String dsIgrejaInvertida) {
		this.dsIgrejaInvertida = dsIgrejaInvertida;
	}

	public String getDsCnpj() {
		return dsCnpj;
	}

	public void setDsCnpj(String dsCnpj) {
		this.dsCnpj = dsCnpj;
	}

	public LocalDate getDtAniversario() {
		return dtAniversario;
	}

	public void setDtAniversario(LocalDate dtAniversario) {
		this.dtAniversario = dtAniversario;
	}

	public Ministro getMinistro() {
		return ministro;
	}

	public void setMinistro(Ministro ministro) {
		this.ministro = ministro;
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

	public String getDsCep() {
		return dsCep;
	}

	public void setDsCep(String dsCep) {
		this.dsCep = dsCep;
	}

	public Estado getEstado() {
		return estado;
	}

	public void setEstado(Estado estado) {
		this.estado = estado;
	}

	public String getDsEmail() {
		return dsEmail;
	}

	public void setDsEmail(String dsEmail) {
		this.dsEmail = dsEmail;
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

	public String getDsCnpjComMascara() {
		return dsCnpjComMascara;
	}

	public void setDsCnpjComMascara(String dsCnpjComMascara) {
		this.dsCnpjComMascara = dsCnpjComMascara;
	}

	public String getDsCepComMascara() {
		return dsCepComMascara;
	}

	public void setDsCepComMascara(String dsCepComMascara) {
		this.dsCepComMascara = dsCepComMascara;
	}
}
