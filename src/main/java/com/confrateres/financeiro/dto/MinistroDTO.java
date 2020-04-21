package com.confrateres.financeiro.dto;

import java.util.List;

public class MinistroDTO {
	
	private Long cdCodigo;
	private String nmNome;
	private String dsEmail;
	private String dsCargo;
	private String dsIgreja;
	private List<RegLancamentoDTO> regLancamentoDTO;

	public Long getCdMinistro() {
		return cdCodigo;
	}

	public void setCdMinistro(Long cdMinistro) {
		this.cdCodigo = cdMinistro;
	}

	public String getNmNome() {
		return nmNome;
	}

	public void setNmNome(String nmNome) {
		this.nmNome = nmNome;
	}

	public String getDsEmail() {
		return dsEmail;
	}

	public void setDsEmail(String dsEmail) {
		this.dsEmail = dsEmail;
	}

	public String getDsCargo() {
		return dsCargo;
	}

	public void setDsCargo(String dsCargo) {
		this.dsCargo = dsCargo;
	}

	public String getDsIgreja() {
		return dsIgreja;
	}

	public void setDsIgreja(String dsIgreja) {
		this.dsIgreja = dsIgreja;
	}

	public List<RegLancamentoDTO> getRegLancamentoDTO() {
		return regLancamentoDTO;
	}

	public void setRegLancamentoDTO(List<RegLancamentoDTO> regLancamentoDTO) {
		this.regLancamentoDTO = regLancamentoDTO;
	}
}
