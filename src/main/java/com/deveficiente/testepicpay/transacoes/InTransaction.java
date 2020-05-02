package com.deveficiente.testepicpay.transacoes;

import java.util.function.Supplier;

import javax.transaction.Transactional;

import org.springframework.stereotype.Component;

@Component
public class InTransaction {
	
	@Transactional
	public <T> T execute(Supplier<T> code) {
		return code.get();
	}
}
