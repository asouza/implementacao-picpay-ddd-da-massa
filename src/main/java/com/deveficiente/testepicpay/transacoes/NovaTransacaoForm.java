package com.deveficiente.testepicpay.transacoes;

import java.math.BigDecimal;
import java.util.function.Function;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

import com.deveficiente.testepicpay.cadastracontas.Dono;

public class NovaTransacaoForm {

	@NotNull
	private final Long donoOrigemId;
	@NotNull
	private final Long donoDestinoId;
	@NotNull
	@Positive
	private final BigDecimal valor;

	public NovaTransacaoForm(@NotNull Long donoOrigemId, @NotNull Long donoDestinoId, @NotNull @Positive BigDecimal valor) {
		super();
		this.donoOrigemId = donoOrigemId;
		this.donoDestinoId = donoDestinoId;
		this.valor = valor;
	}

	public Transacao toModel(Function<Long, Dono> finder) {
		Dono donoOrigem = finder.apply(donoOrigemId);
		Dono donoDestino = finder.apply(donoDestinoId);
		return new Transacao(donoOrigem,donoDestino,valor);
	}

	public boolean temMesmaOrigemEDestino() {
		return donoOrigemId.equals(donoDestinoId);
	}


}
