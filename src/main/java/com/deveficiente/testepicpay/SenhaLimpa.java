package com.deveficiente.testepicpay;

import javax.validation.constraints.NotBlank;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class SenhaLimpa {

	private @NotBlank String valor;
	private BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();

	public SenhaLimpa(@NotBlank String valor) {
		this.valor = valor;
	}
	
	public String hash() {
		return bCryptPasswordEncoder.encode(valor);
	}

	
}
