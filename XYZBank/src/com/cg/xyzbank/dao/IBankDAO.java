package com.cg.xyzbank.dao;

import com.cg.xyzbank.bean.BankBean;
import com.cg.xyzbank.bean.CustomerBean;

public interface IBankDAO {

	boolean addCustomer(BankBean bankBean);

	boolean update(BankBean bankBean);
	
	BankBean find(Long phoneNumber);

}
