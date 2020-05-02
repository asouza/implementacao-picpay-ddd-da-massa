package com.deveficiente.testepicpay;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface DonoRepository
		extends org.springframework.data.repository.Repository<Dono, Long>, JpaSpecificationExecutor<Dono> {

}
