package com.deveficiente.testepicpay.listacontas;

import javax.persistence.criteria.Path;
import javax.persistence.criteria.Predicate;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.util.StringUtils;

import com.deveficiente.testepicpay.cadastracontas.Dono;
import com.deveficiente.testepicpay.cadastracontas.Usuario;

public class BuscaUsuariosForm {

	private String q;

	public void setQ(String q) {
		this.q = q;
	}

	public Specification<Dono> toSpec() {
		return (root, query, builder) -> {
			if (StringUtils.hasLength(q)) {
				Path<String> nomeCompleto = root.<Usuario>get("usuario").<String>get("nomeCompleto");
				Path<String> username = root.<String>get("username");
				
				Predicate condicao = builder.or(builder.like(nomeCompleto, q+"%")
						,builder.like(username, q+"%"));
				
				return condicao;
				
			}
			
			//nao tem o que fazer, o spring data pede retorno nulo ou lista vazia quando nao é para aplicar nada
			return null;
		};
	}

}
