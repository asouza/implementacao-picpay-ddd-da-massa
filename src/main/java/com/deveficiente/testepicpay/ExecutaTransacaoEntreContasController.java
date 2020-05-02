package com.deveficiente.testepicpay;

import java.util.Optional;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ExecutaTransacaoEntreContasController {
	
	@Autowired
	private AutorizadorDeTransacoes autorizadorDeTransacoes;
	@Autowired
	private EntityManager manager;
	
	@PostMapping(value = "/transacoes")
	@Transactional
	public ResponseEntity<?> execute(@Valid NovaTransacaoForm form) {
		Optional<Transacao> transacao = autorizadorDeTransacoes.autoriza(form);
		if(!transacao.isPresent()) {
			return ResponseEntity.status(401).body("valor nao autorizado");
		}
		
		manager.persist(transacao.get());
		return ResponseEntity.ok().build();
		
	}

}
