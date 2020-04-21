package com.confrateres.financeiro.services;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.confrateres.financeiro.model.Boleto;
import com.confrateres.financeiro.model.RegLancamento;
import com.confrateres.financeiro.repository.BoletoRepository;
import com.confrateres.financeiro.services.exception.BoletoNaoRegistradoException;

@Service
public class BoletoService {

	@Autowired
	BoletoRepository boletoRepository;

	// Salvar Boletos
	@Transactional
	public void salvar(Boleto[] boleto) {
		try {
			// Verificar se trata-se de inclusão ou alteração do boleto
			for (Boleto bol : boleto) {
				Boleto boletoTemp;
				for (RegLancamento reg : bol.getRegLancamentos()) {
					// Definido reg.getSqRegLancamento() = 0, quando é para incluir somente Inscrição OUTROS
					System.out.println("reg.getSqRegLancamento(): " + reg.getSqRegLancamento());
					if(reg.getSqRegLancamento() != 0) {
						boletoTemp = boletoRepository.findBoletoPorRegLancamento(reg.getSqRegLancamento());

						if(boletoTemp != null) {
							boletoTemp.setDsUrl(bol.getDsUrl());
							boletoRepository.save(boletoTemp);

						} else {
							boletoTemp = new Boleto();
							boletoTemp.setRegLancamento(new RegLancamento());

							boletoTemp.setDsUrl(bol.getDsUrl());
							boletoTemp.getRegLancamento().setSqRegLancamento(reg.getSqRegLancamento());
							boletoRepository.save(boletoTemp);
						}
					} else {
						boletoTemp = new Boleto();
						
						boletoTemp.setDsUrl(bol.getDsUrl());
						boletoTemp.setRegLancamento(null);
						boletoRepository.save(boletoTemp);
					}

				}

			}
		} catch (Exception e) {
			throw new BoletoNaoRegistradoException("Falha ao tentar registrar boleto na base de dados da CONFRATERES.");
		}
	}


}
