package com.deveficiente.testepicpay;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

import org.springframework.util.Assert;

@Entity
public class Transacao {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@NotNull
	@ManyToOne
	private Dono donoOrigem;
	@NotNull
	@ManyToOne
	private Dono donoDestino;
	private @NotNull @Positive BigDecimal valor;

	public Transacao(Dono donoOrigem, Dono donoDestino, @NotNull @Positive BigDecimal valor) {
		Assert.isTrue(!donoDestino.equals(donoOrigem), "origem e destino precisam ser diferente para uma transacao");
		this.donoOrigem = donoOrigem;
		this.donoDestino = donoDestino;
		this.valor = valor;
	}

}
