package com.confrateres.financeiro.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.confrateres.financeiro.dto.MinistroDTO;
import com.confrateres.financeiro.services.RegLancamentoService;

@RestController
@RequestMapping("/regLancamento")
public class RegLancamentoResource {
	
	@Autowired
	private RegLancamentoService regLancamentoBO ;
	
	
	@RequestMapping(value = "/{codigoMinistro}/{cpfMinistro}/{dtNascimentoMinistro}/{nomeMinistro}", method = RequestMethod.GET)  
	public ResponseEntity<MinistroDTO> listarPendencias(
									@PathVariable("codigoMinistro") Long codigoMinistro,
									@PathVariable("cpfMinistro") String cpfMinistro,
									@PathVariable("dtNascimentoMinistro") String dtNascimentoMinistro,
									@PathVariable("nomeMinistro") String nomeMinistro) {
		
		MinistroDTO ministroDTO = regLancamentoBO.listarPendencias(codigoMinistro, cpfMinistro, dtNascimentoMinistro, nomeMinistro);
		
		return ResponseEntity.status(HttpStatus.OK).body(ministroDTO); // Retorna status 200 + corpo da mensagem
		
	}

}
