package com.deveficiente.testepicpay;

import java.math.BigDecimal;
import java.util.function.Function;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

public class NovaTransacaoForm {

	@NotNull
	private Long donoOrigemId;
	@NotNull
	private Long donoDestinoId;
	@NotNull
	@Positive
	private BigDecimal valor;

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

	public boolean aceita(BigDecimal outroValor) {
		return valor.compareTo(outroValor) > 0 ;
	}

}