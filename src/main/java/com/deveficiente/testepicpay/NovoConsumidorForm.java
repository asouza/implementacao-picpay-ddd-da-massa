package com.deveficiente.testepicpay;

import java.util.function.BiFunction;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class NovoConsumidorForm {

	@NotBlank
	@UniqueValue(domainAttribute = "username", klass = Dono.class)
	private String username;
	@NotNull
	@ExistsId(domainAttribute = "id", klass = Usuario.class)
	@UniqueValue(domainAttribute = "usuario.id",klass = Consumidor.class)
	private Long usuarioId;

	public NovoConsumidorForm(@NotBlank String username, @NotNull Long usuarioId) {
		super();
		this.username = username;
		this.usuarioId = usuarioId;
	}

	public Consumidor toModel(BiFunction<Class<?>, Long, Object> finderById) {
		Usuario usuario = (Usuario) finderById.apply(Usuario.class, usuarioId);		
		return new Consumidor(username,usuario);
	}

}
