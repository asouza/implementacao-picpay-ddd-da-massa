package com.deveficiente.testepicpay.transacoes;

import javax.persistence.EntityManager;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.deveficiente.testepicpay.cadastracontas.Dono;

@RestController
public class ExecutaTransacaoEntreContasController {
	
	@Autowired
	private AutorizadorDeTransacoes autorizadorDeTransacoes;
	@Autowired
	private EntityManager manager;
	@Autowired
	private InTransaction inTransaction;
	
	@InitBinder
	public void init(WebDataBinder binder) {
		binder.addValidators(new TransacaoNaoPodeTerMesmaOrigemEDestinoValidator());
	}
	
	@PostMapping(value = "/transacoes")	
	public ResponseEntity<?> execute(@Valid NovaTransacaoForm form) {
		ResponseEntity<?> response = autorizadorDeTransacoes.autoriza(form);
		
		if(response.getStatusCode().equals(HttpStatus.UNAUTHORIZED)) {
			return response;
		}
		
		return inTransaction.execute(() -> {
			Transacao novaTransacao = form.toModel(id -> manager.find(Dono.class, id));
			manager.persist(novaTransacao);
			return ResponseEntity.ok().build();			
		});
		
	}

}
