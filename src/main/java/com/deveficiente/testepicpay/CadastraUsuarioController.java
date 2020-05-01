package com.deveficiente.testepicpay;

import javax.validation.Valid;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CadastraUsuarioController {

	@PostMapping(value = "/usuarios")
	public void execute(@Valid NovoUsuarioForm form) {
		
		System.out.println(form);
	}

}
