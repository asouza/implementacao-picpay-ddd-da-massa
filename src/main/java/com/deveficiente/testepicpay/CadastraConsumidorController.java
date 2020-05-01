package com.deveficiente.testepicpay;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CadastraConsumidorController {
	
	@PersistenceContext
	private EntityManager manager;

	@PostMapping(value = "/consumidores")
	@Transactional
	public void execute(@Valid NovoConsumidorForm form) {
		manager.persist(form.toModel(manager :: find));
	}

}
