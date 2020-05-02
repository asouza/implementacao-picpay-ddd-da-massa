package com.deveficiente.testepicpay.listacontas;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import com.deveficiente.testepicpay.cadastracontas.Dono;

@Repository
public interface DonoRepository
		extends JpaRepository<Dono, Long>, JpaSpecificationExecutor<Dono> {

	
}
