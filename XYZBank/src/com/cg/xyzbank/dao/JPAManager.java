package com.cg.xyzbank.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.cg.xyzbank.bean.BankBean;

public class JPAManager {
	
	public static EntityManager createEntityManager() {

		EntityManagerFactory factory = Persistence.createEntityManagerFactory("JPA-PU");
		EntityManager em = factory.createEntityManager();

		return em;

	}

	public static BankBean close(EntityManager manager) {

		
		manager.close();
		return null;
	}

}
