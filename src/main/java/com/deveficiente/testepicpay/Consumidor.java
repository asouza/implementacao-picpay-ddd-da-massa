package com.deveficiente.testepicpay;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;

@Entity
public class Consumidor {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@NotNull
	@OneToOne(cascade = CascadeType.PERSIST)
	private UserName userName;
	@NotNull
	@OneToOne
	private Usuario usuario;

	public Consumidor(@NotNull UserName userName, @NotNull Usuario usuario) {
		this.userName = userName;
		this.usuario = usuario;
	}

}
