package com.deveficiente.testepicpay;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CadastraLojistaController {

	@PersistenceContext
	private EntityManager manager;

	@PostMapping(value = "/lojistas")
	@Transactional
	public void execute(@Valid NovoLojistaForm form) {
		System.out.println(form);
	}

}
