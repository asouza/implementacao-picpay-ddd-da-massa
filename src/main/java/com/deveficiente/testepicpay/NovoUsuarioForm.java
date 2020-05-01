package com.deveficiente.testepicpay;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

import org.hibernate.validator.constraints.br.CPF;

public class NovoUsuarioForm {

	@NotBlank
	private String nomeCompleto;
	@CPF
	@UniqueValue(domainAttribute="cpf",klass=Usuario.class)
	private String cpf;
	@NotBlank
	private String numeroTelefone;
	@NotBlank
	@Email
	@UniqueValue(domainAttribute="email",klass=Usuario.class)
	private String email;
	@NotBlank
	private String senha;

	public NovoUsuarioForm(@NotBlank String nomeCompleto, @CPF String cpf, @NotBlank String numeroTelefone,
			@NotBlank @Email String email, @NotBlank String senha) {
		super();
		this.nomeCompleto = nomeCompleto;
		this.cpf = cpf;
		this.numeroTelefone = numeroTelefone;
		this.email = email;
		this.senha = senha;
	}

	@Override
	public String toString() {
		return "NovoUsuarioForm [nomeCompleto=" + nomeCompleto + ", cpf=" + cpf + ", numeroTelefone=" + numeroTelefone
				+ ", email=" + email + ", senha=" + senha + "]";
	}

	public Usuario toModel() {
		return new Usuario(nomeCompleto,cpf,numeroTelefone,email,new SenhaLimpa(senha));
	}

}
