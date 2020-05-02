package com.deveficiente.testepicpay;

import java.math.BigDecimal;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import feign.FeignException;

@FeignClient(url = "http://localhost:8081", name = "autorizador")
public interface AutorizadorDeTransacoes {

	@GetMapping("/autoriza")
	ResponseEntity<?> _autoriza(@RequestParam("donoOrigemId") Long donoOrigemId, @RequestParam("donoDestinoId") Long donoDestinoId, @RequestParam("valor") BigDecimal valor);
	
	default ResponseEntity<?> autoriza(@RequestParam("donoOrigemId") Long donoOrigemId, @RequestParam("donoDestinoId") Long donoDestinoId, @RequestParam("valor") BigDecimal valor){
		try {
			return this._autoriza(donoOrigemId, donoDestinoId, valor);
		} catch (FeignException e) {
			if(e.status() == 401) {
				return ResponseEntity.status(401).build();
			}			
			throw e;
		}
		
	}

}
