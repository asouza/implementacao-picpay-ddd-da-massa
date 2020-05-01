package com.deveficiente.testepicpay;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

import org.hibernate.validator.constraints.br.CPF;

@Entity
public class Usuario {


	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private @NotBlank String nomeCompleto;
	private @CPF String cpf;
	private @NotBlank String numeroTelefone;
	private @NotBlank @Email String email;
	private @NotBlank String senha;
	
	/**
	 * 
	 * @param nomeCompleto
	 * @param cpf
	 * @param numeroTelefone
	 * @param email
	 * @param senha
	 */
	public Usuario(@NotBlank String nomeCompleto, @CPF String cpf, @NotBlank String numeroTelefone,
			@NotBlank @Email String email, @NotBlank SenhaLimpa senhaLimpa) {
				this.nomeCompleto = nomeCompleto;
				this.cpf = cpf;
				this.numeroTelefone = numeroTelefone;
				this.email = email;
				this.senha = senhaLimpa.hash();
	}
}
