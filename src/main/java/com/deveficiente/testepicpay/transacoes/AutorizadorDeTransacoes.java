package com.deveficiente.testepicpay.transacoes;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.cloud.openfeign.SpringQueryMap;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(url = "http://localhost:8081", name = "autorizador")
public interface AutorizadorDeTransacoes {

	@GetMapping("/autoriza")
	void autoriza(@SpringQueryMap NovaTransacaoForm form);

}
