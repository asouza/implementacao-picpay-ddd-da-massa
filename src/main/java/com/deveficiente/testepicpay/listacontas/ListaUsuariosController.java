package com.deveficiente.testepicpay.listacontas;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.deveficiente.testepicpay.cadastracontas.Dono;

@RestController
public class ListaUsuariosController {

	@Autowired
	private DonoRepository donoRepository;

	@GetMapping(value = "/usuarios")
	public Collection<UsuarioItemListaDTO> execute(BuscaUsuariosForm form) {
		List<Dono> usuariosEncontrados = donoRepository.findAll(form.toSpec());
		return usuariosEncontrados.stream().map(UsuarioItemListaDTO::new).collect(Collectors.toList());
	}

}
