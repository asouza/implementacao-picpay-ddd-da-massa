package com.deveficiente.testepicpay;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.br.CNPJ;

public class NovoLojistaForm {

	@NotBlank
	// deveria ser unico?
	private String razaoSocial;
	@NotBlank
	private String nomeFantasia;
	@CNPJ
	@NotBlank
	// deveria ser unico?
	private String cnpj;
	@NotBlank
	// @UniqueValue(domainAttribute = "username",)
	private String username;
	@NotNull
	@ExistsId(domainAttribute = "id", klass = Usuario.class)
	private Long usuarioId;

	public NovoLojistaForm(@NotBlank String razaoSocial, @NotBlank String nomeFantasia, @CNPJ @NotBlank String cnpj,
			@NotBlank String username, @NotNull Long usuarioId) {
		super();
		this.razaoSocial = razaoSocial;
		this.nomeFantasia = nomeFantasia;
		this.cnpj = cnpj;
		this.username = username;
		this.usuarioId = usuarioId;
	}

	@Override
	public String toString() {
		return "NovoLojistaForm [razaoSocial=" + razaoSocial + ", nomeFantasia=" + nomeFantasia + ", cnpj=" + cnpj
				+ ", username=" + username + ", usuarioId=" + usuarioId + "]";
	}

}