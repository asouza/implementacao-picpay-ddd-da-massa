package com.deveficiente.testepicpay;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.br.CNPJ;

@Entity
public class Lojista {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private @NotBlank String razaoSocial;
	private @NotBlank String nomeFantasia;
	private @CNPJ @NotBlank String cnpj;
	@OneToOne(cascade = CascadeType.PERSIST)
	@NotNull
	private Dono dono;

	public Lojista(@NotBlank String razaoSocial, @NotBlank String nomeFantasia, @CNPJ @NotBlank String cnpj,
			@NotBlank String username, Usuario usuario) {
				this.razaoSocial = razaoSocial;
				this.nomeFantasia = nomeFantasia;
				this.cnpj = cnpj;
				this.dono = new Dono(username,usuario);
	}

}
