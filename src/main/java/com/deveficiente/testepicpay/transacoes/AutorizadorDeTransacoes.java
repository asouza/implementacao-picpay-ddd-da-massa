package com.deveficiente.testepicpay.transacoes;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.cloud.openfeign.SpringQueryMap;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

import feign.FeignException;

@FeignClient(url = "http://localhost:8081", name = "autorizador")
public interface AutorizadorDeTransacoes {

	@GetMapping("/autoriza")
	ResponseEntity<?> _autoriza(@SpringQueryMap NovaTransacaoForm form);
	
	default ResponseEntity<?> autoriza(NovaTransacaoForm form){
		try {
			return this._autoriza(form);
		} catch (FeignException e) {
			if(e.status() == 401) {
				return ResponseEntity.status(401).build();
			}			
			throw e;
		}
		
	}

}
