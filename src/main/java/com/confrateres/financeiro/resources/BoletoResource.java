package com.confrateres.financeiro.resources;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.confrateres.financeiro.model.Boleto;
import com.confrateres.financeiro.services.BoletoService;

@RestController
@RequestMapping("/boleto")
public class BoletoResource {
	
	@Autowired
	private BoletoService boletoService;
	
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Void> salvar(@Valid @RequestBody Boleto[] boleto) {
				
		boletoService.salvar(boleto);
	
		
		// Mapeamento para que a URI do Boleto 
		
		return ResponseEntity.status(HttpStatus.CREATED).build(); // Retorna status 201
	}

}
