package com.deveficiente.testepicpay;

import java.math.BigDecimal;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AutorizadorDeTransacoes {
	
	@Autowired
	private DonoRepository donoRepository;	
	
	public Optional<Transacao> autoriza(@Valid NovaTransacaoForm form) {
		if(form.aceita(new BigDecimal(100))) {
			return Optional.empty();
		}
		return Optional.of(form.toModel(donoRepository :: getOne));
	}

}
