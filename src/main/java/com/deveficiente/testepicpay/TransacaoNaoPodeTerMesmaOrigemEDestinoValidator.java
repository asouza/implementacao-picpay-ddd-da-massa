package com.deveficiente.testepicpay;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

public class TransacaoNaoPodeTerMesmaOrigemEDestinoValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		return clazz.isAssignableFrom(NovaTransacaoForm.class);
	}

	@Override
	public void validate(Object target, Errors errors) {
		NovaTransacaoForm form = (NovaTransacaoForm) target;
		if(form.temMesmaOrigemEDestino()) {
			errors.rejectValue(null, null, "a origem precisa diferente do destino");
		}
	}

}
