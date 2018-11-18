package com.cg.xyzbank.service;

import com.cg.xyzbank.bean.BankBean;
import com.cg.xyzbank.bean.CustomerBean;

public interface IBankService {

	boolean addCustomer(BankBean bankBean);

	boolean validations(CustomerBean customerBean,BankBean bankBean) throws Exception;

	boolean deposit(BankBean bankBean, double depositAmount);

	boolean withDraw(BankBean bankBean, double amount);
	boolean fundTransfer(double transferAmount,BankBean senderPhoneNumber,BankBean recievePhoneNumber);

	BankBean find(Long phoneNo);

	

}
