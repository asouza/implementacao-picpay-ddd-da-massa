package com.deveficiente.testepicpay;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
public class Dono {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private @NotBlank String username;
	@NotNull
	@ManyToOne
	private Usuario usuario;
	
	@Deprecated
	public Dono() {

	}

	public Dono(@NotBlank String username,@NotNull Usuario usuario) {
		this.username = username;
		this.usuario = usuario;
	}

	public Usuario getUsuario() {
		return usuario;
	}

}
