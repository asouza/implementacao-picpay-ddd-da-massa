package com.deveficiente.testepicpay.cadastracontas;

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
	
	@Deprecated
	public Usuario() {

	}
	
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

	public Long getId() {
		return id;
	}

	public String getNomeCompleto() {
		return nomeCompleto;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cpf == null) ? 0 : cpf.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Usuario other = (Usuario) obj;
		if (cpf == null) {
			if (other.cpf != null)
				return false;
		} else if (!cpf.equals(other.cpf))
			return false;
		return true;
	}
	
	
}
