package com.deveficiente.testepicpay;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface DonoRepository
		extends JpaRepository<Dono, Long>, JpaSpecificationExecutor<Dono> {

	
}
