package com.deveficiente.testepicpay.transacoes;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import feign.FeignException;

@RestControllerAdvice
public class RestControllerExceptionHandler {

	@ExceptionHandler(FeignException.class)
	public ResponseEntity<?> handleFeignStatusException(FeignException e) {
		return ResponseEntity.status(e.status()).build();
	}

}
