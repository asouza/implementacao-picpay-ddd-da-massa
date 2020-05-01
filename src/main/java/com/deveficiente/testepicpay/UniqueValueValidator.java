package com.deveficiente.testepicpay;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class UniqueValueValidator implements ConstraintValidator<UniqueValue, String>{
	
	private String domainAttribute;
	private Class<Usuario> klass;
	@PersistenceContext
	private EntityManager manager;

	@Override
	public void initialize(UniqueValue params) {
		domainAttribute = params.domainAttribute();
		klass = params.klass();
	}

	@Override
	public boolean isValid(String value, ConstraintValidatorContext context) {
		Query query = manager.createQuery("select 1 from "+klass.getName()+" where "+domainAttribute+"=:value");
		query.setParameter("value", value);
		return query.getResultList().isEmpty();
	}

}