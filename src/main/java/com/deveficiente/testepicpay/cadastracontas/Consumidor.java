package com.deveficiente.testepicpay.cadastracontas;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
public class Consumidor {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@NotNull
	@OneToOne(cascade = CascadeType.PERSIST)
	private Dono dono;

	public Consumidor(@NotBlank String username, Usuario usuario) {
		this.dono = new Dono(username, usuario);
	}

}
