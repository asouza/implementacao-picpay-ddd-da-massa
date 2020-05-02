package com.deveficiente.testepicpay.listacontas;

import com.deveficiente.testepicpay.cadastracontas.Dono;
import com.deveficiente.testepicpay.cadastracontas.Usuario;

public class UsuarioItemListaDTO {

	private Long id;
	private String nomeCompleto;

	public UsuarioItemListaDTO(Dono dono) {
		Usuario usuario = dono.getUsuario();
		
		this.id = usuario.getId();
		this.nomeCompleto = usuario.getNomeCompleto();
	}
	
	public Long getId() {
		return id;
	}
	
	public String getNomeCompleto() {
		return nomeCompleto;
	}
}
