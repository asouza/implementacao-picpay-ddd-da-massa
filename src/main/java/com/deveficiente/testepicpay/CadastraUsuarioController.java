package com.deveficiente.testepicpay;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Validated
public class CadastraUsuarioController {
	
	@PersistenceContext
	private EntityManager manager;	

	@PostMapping(value = "/usuarios")
	@Transactional
	public void execute(@Valid NovoUsuarioForm form) {		
		manager.persist(form.toModel());
	}

}
