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
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "tb_min_ministro")
public class Ministro {
	
	@Id
	@Column(name = "min_sq_ministro")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long sqMinistro;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "dpt_sq_departamento", nullable = false)
	private Departamento departamento;
	
	@Column(name = "min_cd_codigo")
	private Long cdCodigo;
	
	@Column(name = "min_nm_nome")
	private String nmNome;
	
	@Column(name = "min_fl_jubilado")
	private boolean flJubilado;
	
	@Column(name = "min_dt_ingresso")
	private LocalDate dtIngresso;
	
	@Column(name = "min_dt_cmvalidade")
	private LocalDate dtCmValidade;
	
	@Column(name = "min_dt_cmatualizada")
	private LocalDate dtCmAtualizada;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "cgo_sq_cargo", nullable = false)
	private Cargo cargo;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "esc_sq_escolaridade", nullable = false)
	private Escolaridade escolaridade;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "prf_sq_profissao")
	private Profissao profissao;
	
	@Column(name = "min_dt_nascimento")
	private LocalDate dtNascimento;
	
	@Column(name = "min_ds_local_nascimento")
	private String dsLocalNascimento;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = " civ_sq_estadocivel", nullable = false)
	private EstadoCivil estadoCivil;
	
	@Column(name = "min_ds_identidade")
	private String dsIdentidade;
	
	@Column(name = "min_ds_cpf")
	private String dsCpf;
	
	@Column(name = "min_ds_endereco")
	private String dsEndereco;
	
	@Column(name = "min_ds_bairro")
	private String dsBairro;
	
	@Column(name = "min_ds_cep")
	private String dsCep;
	
	@Column(name = "min_ds_cidade")
	private String dsCidade;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "est_sq_estado", nullable = false)
	private Estado estado;
	
	@Column(name = "min_ds_telefone01")
	private String dsTelefone01;
	
	@Column(name = "min_ds_telefone02")
	private String dsTelefone02;
	
	@Column(name = "min_ds_telefone03")
	private String dsTelefone03;
	
	@Column(name = "min_dt_batismo")
	private LocalDate dtBatismo;
	
	@Column(name = "min_dt_ordenado")
	private LocalDate dtOrdenado;
	
	@Column(name = "min_nm_pai")
	private String nmPai;
	
	@Column(name = "min_nm_mae")
	private String nmMae;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "min_sq_ministro_conjuge", nullable = false)
	private Ministro conjuge;
	
	@Column(name = "min_dt_nascimento_esposa")
	private LocalDate dtNascimentoEsposa;
	
	@Column(name = "min_ds_email")
	private String dsEmail;
	
	@NotNull
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "igr_sq_igreja", nullable = false)
	private Igreja igreja;
	
	@Column(name = "min_fl_igrejasede")
	private boolean flIgrejaSede;
	
	@Column(name = "min_cd_cgadb")
	private String cdCgadb;
	
	@Column(name = "min_ds_historico")
	private String dsHistorico;
	
	@Column(name = "min_dt_excluido")
	private LocalDate dtExcluido;
	
	@Column(name = "min_ds_foto")
	private String dsFoto;
	
	@Column(name = "auditoria_data")
	private LocalDateTime auditoria_data;
	
	@Column(name = "auditoria_usuario")
	private String auditoria_usuario;

	public Long getSqMinistro() {
		return sqMinistro;
	}

	public void setSqMinistro(Long sqMinistro) {
		this.sqMinistro = sqMinistro;
	}

	public Departamento getDepartamento() {
		return departamento;
	}

	public void setDepartamento(Departamento departamento) {
		this.departamento = departamento;
	}

	public Long getCdCodigo() {
		return cdCodigo;
	}

	public void setCdCodigo(Long cdCodigo) {
		this.cdCodigo = cdCodigo;
	}

	public String getNmNOme() {
		return nmNome;
	}

	public void setNmNOme(String nmNOme) {
		this.nmNome = nmNOme;
	}

	public boolean isFlJubilado() {
		return flJubilado;
	}

	public void setFlJubilado(boolean flJubilado) {
		this.flJubilado = flJubilado;
	}

	public LocalDate getDtIngresso() {
		return dtIngresso;
	}

	public void setDtIngresso(LocalDate dtIngresso) {
		this.dtIngresso = dtIngresso;
	}

	public LocalDate getDtCmValidade() {
		return dtCmValidade;
	}

	public void setDtCmValidade(LocalDate dtCmValidade) {
		this.dtCmValidade = dtCmValidade;
	}

	public LocalDate getDtCmAtualizada() {
		return dtCmAtualizada;
	}

	public void setDtCmAtualizada(LocalDate dtCmAtualizada) {
		this.dtCmAtualizada = dtCmAtualizada;
	}

	public Cargo getCargo() {
		return cargo;
	}

	public void setCargo(Cargo cargo) {
		this.cargo = cargo;
	}

	public Escolaridade getEscolaridade() {
		return escolaridade;
	}

	public void setEscolaridade(Escolaridade escolaridade) {
		this.escolaridade = escolaridade;
	}

	public Profissao getProfissao() {
		return profissao;
	}

	public void setProfissao(Profissao profissao) {
		this.profissao = profissao;
	}

	public LocalDate getDtNascimento() {
		return dtNascimento;
	}

	public void setDtNascimento(LocalDate dtNascimento) {
		this.dtNascimento = dtNascimento;
	}

	public String getDsLocalNascimento() {
		return dsLocalNascimento;
	}

	public void setDsLocalNascimento(String dsLocalNascimento) {
		this.dsLocalNascimento = dsLocalNascimento;
	}

	public EstadoCivil getEstadoCivil() {
		return estadoCivil;
	}

	public void setEstadoCivil(EstadoCivil estadoCivil) {
		this.estadoCivil = estadoCivil;
	}

	public String getDsIdentidade() {
		return dsIdentidade;
	}

	public void setDsIdentidade(String dsIdentidade) {
		this.dsIdentidade = dsIdentidade;
	}

	public String getDsCpf() {
		return dsCpf;
	}

	public void setDsCpf(String dsCpf) {
		this.dsCpf = dsCpf;
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

	public String getDsCep() {
		return dsCep;
	}

	public void setDsCep(String dsCep) {
		this.dsCep = dsCep;
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

	public String getDsTelefone01() {
		return dsTelefone01;
	}

	public void setDsTelefone01(String dsTelefone01) {
		this.dsTelefone01 = dsTelefone01;
	}

	public String getDsTelefone02() {
		return dsTelefone02;
	}

	public void setDsTelefone02(String dsTelefone02) {
		this.dsTelefone02 = dsTelefone02;
	}

	public String getDsTelefone03() {
		return dsTelefone03;
	}

	public void setDsTelefone03(String dsTelefone03) {
		this.dsTelefone03 = dsTelefone03;
	}

	public LocalDate getDtBatismo() {
		return dtBatismo;
	}

	public void setDtBatismo(LocalDate dtBatismo) {
		this.dtBatismo = dtBatismo;
	}

	public LocalDate getDtOrdenado() {
		return dtOrdenado;
	}

	public void setDtOrdenado(LocalDate dtOrdenado) {
		this.dtOrdenado = dtOrdenado;
	}

	public String getNmPai() {
		return nmPai;
	}

	public void setNmPai(String nmPai) {
		this.nmPai = nmPai;
	}

	public String getNmMae() {
		return nmMae;
	}

	public void setNmMae(String nmMae) {
		this.nmMae = nmMae;
	}

	public Ministro getConjuge() {
		return conjuge;
	}

	public void setConjuge(Ministro conjuge) {
		this.conjuge = conjuge;
	}

	public LocalDate getDtNascimentoEsposa() {
		return dtNascimentoEsposa;
	}

	public void setDtNascimentoEsposa(LocalDate dtNascimentoEsposa) {
		this.dtNascimentoEsposa = dtNascimentoEsposa;
	}

	public String getDsEmail() {
		return dsEmail;
	}

	public void setDsEmail(String dsEmail) {
		this.dsEmail = dsEmail;
	}

	public Igreja getIgreja() {
		return igreja;
	}

	public void setIgreja(Igreja igreja) {
		this.igreja = igreja;
	}

	public boolean isFlIgrejaSede() {
		return flIgrejaSede;
	}

	public void setFlIgrejaSede(boolean flIgrejaSede) {
		this.flIgrejaSede = flIgrejaSede;
	}

	public String getCdCgadb() {
		return cdCgadb;
	}

	public void setCdCgadb(String cdCgadb) {
		this.cdCgadb = cdCgadb;
	}

	public String getDsHistorico() {
		return dsHistorico;
	}

	public void setDsHistorico(String dsHistorico) {
		this.dsHistorico = dsHistorico;
	}

	public LocalDate getDtExcluido() {
		return dtExcluido;
	}

	public void setDtExcluido(LocalDate dtExcluido) {
		this.dtExcluido = dtExcluido;
	}

	public String getDsFoto() {
		return dsFoto;
	}

	public void setDsFoto(String dsFoto) {
		this.dsFoto = dsFoto;
	}

	public LocalDateTime getAuditoria_data() {
		return auditoria_data;
	}

	public void setAuditoria_data(LocalDateTime auditoria_data) {
		this.auditoria_data = auditoria_data;
	}

	public String getAuditoria_usuario() {
		return auditoria_usuario;
	}

	public void setAuditoria_usuario(String auditoria_usuario) {
		this.auditoria_usuario = auditoria_usuario;
	}
}
