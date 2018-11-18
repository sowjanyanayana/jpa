package com.cg.xyzbank.dao;

import javax.persistence.EntityManager;

import com.cg.xyzbank.bean.BankBean;

public class BankDAOImpl implements IBankDAO {

	@Override
	public boolean addCustomer(BankBean bankBean) {
		
		try {	
			EntityManager manager=JPAManager.createEntityManager();
	
			manager.getTransaction().begin();

			manager.persist(bankBean);
	
			manager.getTransaction().commit();
			JPAManager.close(manager);
		
			return true;
			
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		
			
		
	}

	@Override
	public boolean update(BankBean bankBean) {

		try {
			EntityManager manager=JPAManager.createEntityManager();	
			manager.getTransaction().begin();
			manager.merge(bankBean);
			manager.getTransaction().commit();
			JPAManager.close(manager);
			return true;
		} catch (Exception e) {
			return false;
		}
		
	}

	@Override
	public BankBean find(Long phoneNumber) {
		try {
			EntityManager manager=JPAManager.createEntityManager();	
			BankBean bankBean=manager.find(BankBean.class,phoneNumber);
			JPAManager.close(manager);

			return bankBean;
		} catch (Exception e) {
			return null;
			}
	}

	

}
